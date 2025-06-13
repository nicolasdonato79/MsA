package com.example.msA.security;

import java.util.List;
import java.util.Map;

public class UserRoleService {

    private static final Map<String, List<String>> USER_ROLES = Map.of(
            "24285246209", List.of("ADMIN", "USER"),
            "12345678900", List.of("USER")
    );

    public List<String> getRolesForUser(String uid) {
        return USER_ROLES.getOrDefault(uid, List.of());
    }
}
