package com.vinicius.gestao_vagas.modules.candidate.entity;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import java.util.UUID;

@Data
public class CandidateEntity {
    private UUID uuid;
    private String name;
    @Pattern(regexp = "\\S+", message = "O campo userName Não deve ter espaço")
    private String userName;
    @Email(message = "O campo Email deve conter um email válido")
    private String email;
    @Length(min = 6, message = "O campo Senha deve conter no mínimo 6 caracteres")
    private String password;
    private String description;
    private String curriculum;

}
