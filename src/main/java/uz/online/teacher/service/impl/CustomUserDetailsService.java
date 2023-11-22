package uz.online.teacher.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import uz.online.teacher.dto.CustomUserDetails;
import uz.online.teacher.exception.LoginOrPasswordWrongEcception;
import uz.online.teacher.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return CustomUserDetails.of(userRepository.findByUsernameAndDeletedFalse(username)
                .orElseThrow(LoginOrPasswordWrongEcception::new));
    }
}
