package com.demo.app.ws.config.security;

public class SecurityConstants {

    public static final long ACCESS_TOKEN_EXPIRATION_TIME = 200000000;
    public static final long REFRESH_TOKEN_EXPIRATION_TIME = 864000000;
    public static final String ACCESS_TOKEN_URL = "/v1/users/login";
    public static final String REFRESH_TOKEN_URL = "/v1/users/token/refresh";
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";
    public static final String SIGN_UP_URL = "/api/v1/users";
    public static final String TOKEN_SECRET = "fzeafzafeziozeiaof4534262J623OJC2523CAZERTYUIOPQSDFGHJKLMWXCVBN";
}
