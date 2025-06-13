package com.example.msA.security;


import org.springframework.core.convert.converter.Converter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class CustomRolesConverter implements Converter<Jwt, Collection<GrantedAuthority>> {

    private final UserRoleService userRoleService = new UserRoleService();

    @Override
    public Collection<GrantedAuthority> convert(Jwt jwt) {
        String username = jwt.getSubject(); // Ej: DNI o UID
        List<String> roles = userRoleService.getRolesForUser(username);

        return roles.stream()
                .map(role -> new SimpleGrantedAuthority("ROLE_" + role))
                .collect(Collectors.toList());
    }
}
