package com.effectivejava.items.utility.security;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public enum RoleNames {
    USER("USER"),
    ADMIN("ADMIN");

    private String value;
}
