package com.academiapro.cms.constants;


public final  class ApiConstants {


    private ApiConstants() {}

    public static final String BASE = ApiVersion.V1; // "/api/v1"

    // AUTH CONSTANTS
    private static final String AUTH = "/auth";
    public static final String REGISTER =  BASE + AUTH + "/register"; // "/api/v1/auth/register"
    public static final String LOGIN =  BASE + AUTH + "/login"; // "/api/v1/auth/login"


}
