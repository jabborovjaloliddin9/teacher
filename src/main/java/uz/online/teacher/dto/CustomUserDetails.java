package uz.online.teacher.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import uz.online.teacher.entity.User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Getter
@AllArgsConstructor(staticName = "of")
public class CustomUserDetails implements UserDetails {

    private User user;
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        if (user.getAuthority() == null)
            return null;

//        List<SimpleGrantedAuthority> grantedAuth = new ArrayList<>();
//        user.getAuthority().forEach(authority -> {
//            List<SimpleGrantedAuthority> collect = authority.getPreviliges().stream().map(previlige -> {
//                return new SimpleGrantedAuthority(previlige.getPrevilige());
//            }).toList();
//            grantedAuth.addAll(collect);
//        });
        return List.of(new SimpleGrantedAuthority(user.getAuthority().getAuthority()));
    }

//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//       return user.getAuthorities().stream().map(authority ->  {
//            return new SimpleGrantedAuthority(authority.getName());
//        }).collect(Collectors.toList());
//    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return !user.isDeleted();
    }
}
