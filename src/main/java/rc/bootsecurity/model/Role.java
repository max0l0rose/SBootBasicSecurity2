package rc.bootsecurity.model;

import org.springframework.security.core.GrantedAuthority;

// Эта хрень не нужна потому что роли должны быть в базе

public enum Role implements GrantedAuthority {
    ADMIN,
    EDITOR,
    CONSULTANT,
    CLIENT;

    @Override
    public String getAuthority() {
        return "ROLE_" + name();
    }
}