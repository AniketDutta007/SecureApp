package com.nrifintech.training.secureapp.models;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Permission {
    ADMIN_READ("admin:read"),
    ADMIN_CREATE("admin:create"),
    ADMIN_UPDATE("admin:update"),
    ADMIN_DELETE("admin:delete"),
    MANAGER_READ("manager:read"),
    MANAGER_CREATE("manager:create"),
    MANAGER_UPDATE("manager:update"),
    MANAGER_DELETE("manager:delete");
    private final String permission;
}
