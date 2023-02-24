package com.iamstevol.vehicleparkingsystem.security.auth;

public enum ApplicationUserPermission {
    USER_READ("user:read"),
    USER_WRITE("user:write"),
    TICKET_READ("ticket:read"),
    TICKET_WRITE("ticket:write");
    private final String permission;
    ApplicationUserPermission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
