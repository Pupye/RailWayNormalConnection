package com.sedbproj.Railways.Entities;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;


public class UserDetailsImpl extends UserEntity implements UserDetails {

    public UserDetailsImpl(UserEntity user) {
        super(user);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> roles = new ArrayList<SimpleGrantedAuthority>();
        roles.add(new SimpleGrantedAuthority("ROLE_USER"));
        String role = null;
        try {
            role = super.getEmployee().getRole();
        } catch(Exception e) {
            System.out.println("Can't find the role of the just logged in user");
        }

        Optional<String> rol = Optional.ofNullable(role);
        rol.ifPresent(s -> roles.add(new SimpleGrantedAuthority("ROLE_" + s.toUpperCase())));

        return roles;
    }

    @Override
    public String getPassword() {
        return super.getPassword();
    }

    @Override
    public String getUsername() {
        return super.getEmail();
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