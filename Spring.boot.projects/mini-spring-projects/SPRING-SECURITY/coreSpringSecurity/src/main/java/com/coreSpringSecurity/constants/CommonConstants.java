package com.coreSpringSecurity.constants;

public class CommonConstants {

    public static final String EMPLOYEE_BASE_PATH = "/employee";




    // /employee/create
    public static final String CREATE_EMPLOYEE = "/create";
    public static final String GET_ALL_EMPLOYEE = "/get-all";
    public static final String DELETE_EMPLOYEE_BY_ID = "/{employeeId}";
    public static final String UPDATE_EMPLOYEE_BY_ID = "/{employeeId}";
    public static final String GET_EMPLOYEE_BY_ID = "/{employeeId}";




    // /roles/create
    public static final String ROLES_BASE_PATH = "/roles";

    public static final String CREATE_ROLES = "/create";
    public static final String GET_ALL_ROLES = "/get-all";
    public static final String UPDATE_ROLES_BY_ID = "/{rolesId}";
    public static final String DELETE_ROLES_BY_ID = "/{rolesId}";
    public static final String GET_ROLES_BY_ID = "/{rolesId}";

    public static final String ASSIGN_ROLE = "/assign-role";
}
