package com.example.formation_teams.model;

import org.springframework.security.core.GrantedAuthority;

public enum SystemRole implements GrantedAuthority {
    ROLE_USER,
    ROLE_SUPER_ADMIN;

    @Override
    public String getAuthority() {
        return name();
    }
}