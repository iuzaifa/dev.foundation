package com.login_Application.loginApp.exceptions;

public class LoginResult extends RuntimeException {

    private String massage;

    public LoginResult() {
        super();
    }

    public LoginResult(String message) {
        super(message);
    }

    public LoginResult(String message, Throwable cause) {
        super(message, cause);
    }

    public LoginResult(Throwable cause) {
        super(cause);
    }
}