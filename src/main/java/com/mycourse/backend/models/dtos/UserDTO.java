package com.mycourse.backend.models.dtos;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Email;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO implements Serializable {
    private Integer id;
    private String name;
    private String type;
    private String email;

    @NotEmpty(message = "E-mail não pode ser vazio.")
    @Email(message = "E-mail inválido.")
    public String getEmail() {
        return email;
    }
}