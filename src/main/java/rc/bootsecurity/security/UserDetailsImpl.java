package rc.bootsecurity.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import rc.bootsecurity.model.Role;
import rc.bootsecurity.model.User;

import java.util.*;


public class UserDetailsImpl implements UserDetails {
    private Optional<User> user;

    public UserDetailsImpl(User u){
        user = Optional.of(u);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();

        // TODO сделать ENUM Role и унаследовать его от GrantedAuthority

//        // Extract list of permissions (name)
//        user.get().getPermissionList().forEach(p -> {
//            GrantedAuthority authority = new SimpleGrantedAuthority(p);
//            authorities.add(authority);
//        });

        // Extract list of roles (ROLE_name)
        Collection<Role> set = user.get().getRoles();
        return set;
//        set.forEach(r -> {
//                //GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_" + r);
//                //r.setAuthority("ROLE_" + r.getName());
//                authorities.add(r);
//            });
//
//        return authorities;
    }

    @Override
    public String getPassword() {
        return user.get().getPassword();
    }

    @Override
    public String getUsername() {
        return user.get().getUsername();
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
        int act = user.get().getActive();
        return act == 1;
    }
}
