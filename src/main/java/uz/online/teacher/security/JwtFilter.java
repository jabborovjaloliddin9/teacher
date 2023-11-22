package uz.online.teacher.security;

import io.micrometer.common.util.StringUtils;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import uz.online.teacher.entity.cache.UserSession;
import uz.online.teacher.exception.ObjectNotFoundException;
import uz.online.teacher.repository.UserSessionRepository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class JwtFilter extends OncePerRequestFilter {

    private final JwtUtil jwtUtil;
    private final UserSessionRepository userSessionRepository;

    @Override
    protected void doFilterInternal(
            @NonNull HttpServletRequest request,
            @NonNull HttpServletResponse response,
            @NonNull FilterChain filterChain) throws ServletException, IOException {

        String authorization = request.getHeader("Authorization");

        if (!StringUtils.isBlank(authorization) && authorization.startsWith("Bearer ")) {
            String token = authorization.substring(7);
            UsernamePasswordAuthenticationToken authenticationToken = null;

            if (jwtUtil.isValid(token)) {

                String sub = jwtUtil.getClaim("sub", token, String.class);

                UserSession userSession = userSessionRepository.findById(sub)
                        .orElseThrow(() -> new ObjectNotFoundException(sub, "userSession"));

                if (userSession.getUser() == null)
                    throw new ObjectNotFoundException(sub, "user");

                authenticationToken = new UsernamePasswordAuthenticationToken(
                        userSession.getUser(),
                        userSession.getUser().getPassword(),
                        List.of(new SimpleGrantedAuthority(userSession.getUser().getAuthority().getAuthority()))
                );
            }
            SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        }

        filterChain.doFilter(request, response);
    }
}
