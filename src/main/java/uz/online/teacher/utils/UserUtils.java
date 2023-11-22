package uz.online.teacher.utils;

import org.springframework.security.core.context.SecurityContextHolder;
import uz.online.teacher.entity.Authority;
import uz.online.teacher.entity.User;
import uz.online.teacher.enums.UserRole;

public class UserUtils {

    public static User getCurrentUser() {
        if (SecurityContextHolder.getContext().getAuthentication() != null) {
            if (SecurityContextHolder.getContext().getAuthentication().getPrincipal() != null) {
                return (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            }
        }
        return null;
    }

    public static Integer getCurrnetUserId() {
        if (getCurrentUser() == null)
            return null;
        return getCurrentUser().getId();
    }


    public static String getUsername() {
        if (getCurrentUser() == null)
            return null;
        return getCurrentUser().getUsername();
    }

    public static Authority getCurrentUserAuthority() {
        if (getCurrentUser() == null)
            return null;
        return getCurrentUser().getAuthority();
    }


    public static String getCurrentUserAuthorityName() {
        if (getCurrentUser() == null)
            return null;
        return getCurrentUser().getAuthority().getAuthority();
    }

    public static boolean hasAuthority(String checkedAuthority) {
        return checkedAuthority.equals(getCurrentUserAuthorityName());
    }

    public static boolean isOrganization() {
        return UserRole.ORGANIZATION.name().equals(getCurrentUserAuthorityName());
    }


    public static boolean isTeacher() {
        return UserRole.TEACHER.name().equals(getCurrentUserAuthorityName());
    }

    public static boolean isStudent() {
        return UserRole.STUDENT.name().equals(getCurrentUserAuthorityName());
    }

    public static boolean isAdmin() {
        return UserRole.ADMIN.name().equals(getCurrentUserAuthorityName());
    }
}
