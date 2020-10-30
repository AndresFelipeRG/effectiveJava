package com.effectivejava.items.utility.security;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum RoleNames {
    USER("USER"),
    ADMIN("ADMIN");

    private String value;
}
