package com.example.demo.contact;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Contact {
    @Min(value=2,message="Input from 2")
    private int id;
    @NotBlank(message = "Name can not null")
    private String name;
    @Email(message = "Wrong email format")
    private String email;
    @Size(min=9,message = "You must type at leas 9 characters")
    private String phone; 

}





