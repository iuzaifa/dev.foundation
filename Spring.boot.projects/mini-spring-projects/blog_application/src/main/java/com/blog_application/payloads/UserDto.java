package com.blog_application.payloads;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserDto {

    private int id;
    private String name;
    private String email;
    private String about;
    private String password;
}