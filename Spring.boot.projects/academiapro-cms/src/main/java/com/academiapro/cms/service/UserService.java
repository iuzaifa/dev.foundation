package com.academiapro.cms.service;

import com.academiapro.cms.dto.LoginRequest;
import com.academiapro.cms.dto.RegisterRequest;

public interface UserService {


    RegisterRequest register(RegisterRequest registerRequest);
    String login (LoginRequest loginRequest);






}
