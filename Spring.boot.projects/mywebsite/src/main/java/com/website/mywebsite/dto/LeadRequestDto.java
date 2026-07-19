package com.website.mywebsite.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class LeadRequestDto {


    @NotBlank(message = "Full name is required")
    @Size(min = 3, max = 50, message = "Full name must be between 3 and 50 characters")
    @Pattern(regexp = "^[A-Za-z ]+$", message = "Full name can only contain alphabets and spaces")
    private String fullName;

    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    private String email;

    @NotBlank(message = "Company name is required")
    @Size(min = 2, max = 100, message = "Company name must be between 2 and 100 characters")
    @Pattern(regexp = "^[A-Za-z0-9 .,&-]+$", message = "Company name contains invalid characters")
    private String companyName;

    @NotBlank(message = "Phone number is required")
    @Pattern(
            regexp = "^(\\+?[0-9]{1,3})?[-.\\s]?\\(?[0-9]{1,4}\\)?[-.\\s]?[0-9]{3,4}[-.\\s]?[0-9]{3,4}$",
            message = "Invalid phone number format (supports international numbers)"
    )
    private String phone;

    @NotBlank(message = "Inquiry type is required")
    @Size(min = 3, max = 50, message = "Inquiry must be at least 3 characters long")
    private String inquiry;

    @NotBlank(message = "Message is required")
    @Size(min = 10, max = 500, message = "Message must be between 10 and 500 characters")
    private String message;

}
