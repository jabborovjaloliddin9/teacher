package uz.online.teacher.service.impl;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import uz.online.teacher.dto.AuthorityDto;
import uz.online.teacher.dto.AuthorityGetAllDto;
import uz.online.teacher.dto.ResponseDto;
import uz.online.teacher.dto.TokenResponseDto;
import uz.online.teacher.dto.form.AuthorityForm;
import uz.online.teacher.dto.form.LoginForm;
import uz.online.teacher.entity.Authority;
import uz.online.teacher.entity.User;
import uz.online.teacher.entity.cache.EmailMessageCode;
import uz.online.teacher.entity.cache.RefreshToken;
import uz.online.teacher.entity.cache.UserSession;
import uz.online.teacher.exception.LoginOrPasswordWrongEcception;
import uz.online.teacher.exception.ObjectAllreadyExistsException;
import uz.online.teacher.exception.ObjectNotFoundException;
import uz.online.teacher.repository.*;
import uz.online.teacher.security.JwtUtil;
import uz.online.teacher.service.AuthorityService;
import uz.online.teacher.utils.RandomUtils;

import java.text.ParseException;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthorityServiceImpl implements AuthorityService {

    private final AuthorityRepository repository;
    private final PreviligeRepository previligeRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserSessionRepository userSessionRepository;
    private final RefreshTokenRepository refreshTokenRepository;
    private final JwtUtil jwtUtil;
    private final EmailServiceImpl emailService;
    private final EmailMessageCacheRepository emailMessageCacheRepository;

    @Override
    public ResponseDto<AuthorityDto> getOne(Integer id) {
        return ResponseDto.<AuthorityDto>builder()
                .success(true)
                .data(AuthorityDto.toDto(get(id)))
                .build();
    }

    @Override
    public ResponseDto<List<AuthorityGetAllDto>> getAll() {
        return ResponseDto.<List<AuthorityGetAllDto>>builder()
                .success(true)
                .data(repository.findAllByDeletedFalse().stream().map(AuthorityGetAllDto::toDto).toList())
                .build();
    }

    @Override
    public ResponseDto<Page<AuthorityDto>> getList(Integer page, Integer size) {
        return ResponseDto.<Page<AuthorityDto>>builder()
                .success(true)
                .data(repository.findAllByDeletedFalse(PageRequest.of(page, size)).map(AuthorityDto::toDto))
                .build();
    }

    @Override
    public ResponseDto<AuthorityDto> create(AuthorityForm form) throws ParseException {
        return ResponseDto.<AuthorityDto>builder()
                .success(true)
                .data(AuthorityDto.toDto(repository.save(fill(new Authority(), form))))
                .build();
    }

    @Override
    public ResponseDto<AuthorityDto> update(Integer id, AuthorityForm form) throws ParseException {
        return ResponseDto.<AuthorityDto>builder()
                .success(true)
                .data(AuthorityDto.toDto(repository.save(fill(get(id), form))))
                .build();
    }

    @Override
    public void delete(Integer id) {
        Authority authority = get(id);
        authority.setDeleted(true);
        repository.save(authority);
    }

    public Authority fill(Authority authority, AuthorityForm form) throws ParseException {
        if (repository.existsByAuthorityAndDeletedFalse(form.getAuthority()))
            throw new ObjectAllreadyExistsException(form.getAuthority(), "authority");
        authority.setAuthority(form.getAuthority());
        authority.setName(form.getName());
        return authority;
    }

    public Authority get(Integer id) {
        return repository.findByIdAndDeletedFalse(id).orElseThrow(() -> new ObjectNotFoundException(id.toString(), "Authority"));
    }


    public ResponseDto<TokenResponseDto> signIn(LoginForm form, HttpServletResponse response) {

        User user = userRepository.findByUsernameAndDeletedFalse(form.getUsername())
                .orElseThrow(LoginOrPasswordWrongEcception::new);

        if (!passwordEncoder.matches(form.getPassword(), user.getPassword()))
            throw new LoginOrPasswordWrongEcception();

        String sessonId = UUID.randomUUID().toString();
        userSessionRepository.save(new UserSession(sessonId, user));
        log.info("user save into cache memory");

        String refreshToken = UUID.randomUUID().toString();
        refreshTokenRepository.save(new RefreshToken(refreshToken, user));

        response.addCookie(new Cookie("authority", user.getAuthority().getAuthority()));

        return ResponseDto.<TokenResponseDto>builder()
                .success(true)
                .data(TokenResponseDto.builder()
                        .accessToken(jwtUtil.generateToken(sessonId))
                        .refreshToken(refreshToken)
                        .build())
                .build();
    }

    public ResponseDto<TokenResponseDto> refreshToken(String refreshToken, HttpServletResponse response) throws Exception {

        RefreshToken refreshTokenEntity = refreshTokenRepository.findById(refreshToken)
                .orElseThrow(() -> new RuntimeException("Bad token"));

        String sessonId = UUID.randomUUID().toString();
        userSessionRepository.save(new UserSession(sessonId, refreshTokenEntity.getUser()));

        refreshToken = UUID.randomUUID().toString();
        refreshTokenRepository.save(new RefreshToken(refreshToken, refreshTokenEntity.getUser()));

        response.addCookie(new Cookie("authority", refreshTokenEntity.getUser().getAuthority().getAuthority()));

        return ResponseDto.<TokenResponseDto>builder()
                .success(true)
                .data(TokenResponseDto.builder()
                        .accessToken(jwtUtil.generateToken(sessonId))
                        .refreshToken(refreshToken)
                        .build())
                .build();
    }

    public ResponseDto<String> sendEmailForResetPassword(String email, String sessionId) {
        User user = userRepository.findByEmailAndDeletedFalse(email)
                .orElseThrow(() -> new ObjectNotFoundException(email, "email"));

        String code = RandomUtils.generateCode(4);
        emailService.sendGmailMessage(user.getEmail(), "Reset password", code);
        emailMessageCacheRepository.save(new EmailMessageCode(sessionId, code));
        userSessionRepository.save(new UserSession(sessionId, user));
        return ResponseDto.<String>builder()
                .success(true)
                .data("We send varification code" + user.getEmail() + " email")
                .build();
    }

    public ResponseDto<String> sendCode(String code, String sessionId) {
        EmailMessageCode emailMessageCode = emailMessageCacheRepository.findById(sessionId)
                .orElseThrow(() -> new RuntimeException("Session not found"));

        if (code == null || !code.equals(emailMessageCode.getCode()))
            throw new RuntimeException("Code is wrong");

        return ResponseDto.<String>builder()
                .success(true)
                .data("Enter new login and password")
                .build();
    }

    @Override
    public ResponseDto<String> resetLoginPassword(LoginForm loginForm, String sessionId) {
        UserSession session = userSessionRepository.findById(sessionId)
                .orElseThrow(() -> new RuntimeException("Session not found"));
        User user = session.getUser();
        user.setUsername(loginForm.getUsername());
        user.setPassword(passwordEncoder.encode(loginForm.getPassword()));
        userRepository.save(user);
        return ResponseDto.<String>builder()
                .success(true)
                .data("login anf password chaged")
                .build();
    }
}
