package uz.online.teacher.service;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.data.domain.Page;
import uz.online.teacher.dto.AuthorityDto;
import uz.online.teacher.dto.AuthorityGetAllDto;
import uz.online.teacher.dto.ResponseDto;
import uz.online.teacher.dto.TokenResponseDto;
import uz.online.teacher.dto.form.AuthorityForm;
import uz.online.teacher.dto.form.LoginForm;

import java.text.ParseException;
import java.util.List;

public interface AuthorityService {

    ResponseDto<AuthorityDto> getOne(Integer id);
    ResponseDto<List<AuthorityGetAllDto>> getAll();
    ResponseDto<Page<AuthorityDto>> getList(Integer page, Integer size);

    ResponseDto<AuthorityDto> create(AuthorityForm form) throws ParseException;

    ResponseDto<AuthorityDto> update(Integer id, AuthorityForm form) throws ParseException;

    void delete(Integer id);

    ResponseDto<TokenResponseDto> signIn(LoginForm form, HttpServletResponse response);

    ResponseDto<TokenResponseDto> refreshToken(String refreshToken, HttpServletResponse response) throws Exception;

    ResponseDto<String> sendEmailForResetPassword(String email, String sessionId);

    ResponseDto<String> sendCode(String code, String sessionId);
    ResponseDto<String> resetLoginPassword(LoginForm loginForm, String sessionId);

}
