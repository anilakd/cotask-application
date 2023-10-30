package com.anilakdemir.cotaskapplication.config.security;

import com.anilakdemir.cotaskapplication.model.User;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.UUID;


@Getter
public class AuthUser implements UserDetails {

    private final UUID id;

    private final String username;

    private final String password;

    private final String email;

    private AuthUser (UUID id, String username, String password, Collection<? extends GrantedAuthority> authorities, String email) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.authorities = authorities;
        this.email = email;
    }

    public static AuthUser create(User user) {

        UUID id = user.getId();
        String username = user.getUsername();
        String password = user.getPassword();
        String email = user.getEmail();

        List<SimpleGrantedAuthority> authorities = List.of(new SimpleGrantedAuthority(user.getRole().name()));

        return new AuthUser(id, username, password, authorities, email);
    }

    private final Collection<? extends GrantedAuthority> authorities;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
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
        return true;
    }
}
