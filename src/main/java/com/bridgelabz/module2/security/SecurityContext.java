package com.bridgelabz.module2.security;

public class SecurityContext {

    private static final ThreadLocal<String> CURRENT_USER =
            new ThreadLocal<>();

    public static void setUser(String username) {
        CURRENT_USER.set(username);
    }

    public static String getUser() {
        return CURRENT_USER.get();
    }

    public static void clear() {
        CURRENT_USER.remove();
    }
}