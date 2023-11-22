package uz.online.teacher.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.context.SecurityContextHolder;
import uz.online.teacher.entity.User;

import java.util.Optional;

@Configuration
public class JpaAuditingConfig implements AuditorAware<String> {
    @Override
    public Optional<String> getCurrentAuditor() {
        Optional<String> username = Optional.of("anonym");
        if (SecurityContextHolder.getContext() != null)
            if (SecurityContextHolder.getContext().getAuthentication() != null)
                if (SecurityContextHolder.getContext().getAuthentication().getPrincipal() != null)
                    username = Optional.of(((User)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername());
        return username;
    }
}
