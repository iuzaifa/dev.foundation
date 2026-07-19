package com.collegemanagementsystem.constant;


public class CommonConstants {



    public static final String API_BASE_PATH = "/cms";



    // STUDENT -> APIS   -> /cms/register-student
    public static final String REGISTER_NEW_STUDENT = "/register-student";
    public static final String GET_ALL_STUDENT = "/get-students";
    public static final String UPDATE_STUDENT_VIA_ID = "/update-student/{studentId}";
    public static final String DELETE_STUDENT_VIA_ID = "/delete-student/{studentId}";

    public static final String STUDENT_FIND_VIA_ID = "/student-find-by-id/{studentId}";
    public static final String CHANGE_EMAIL_VIA_ID = "/change-email-by-id/{studentId}";
}
