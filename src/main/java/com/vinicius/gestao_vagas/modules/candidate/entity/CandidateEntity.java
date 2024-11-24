package com.vinicius.gestao_vagas.modules.candidate.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;
import java.util.UUID;

// @Data -> Gerar getters e setters automaticamente
@Data
// @Entity -> Define a classe como uma entidade do JPA, passando o nome da tabela.
@Entity(name = "candidate")
public class CandidateEntity {
    // @Id -> Define a chave primária da entidade
    @Id
// @GeneratedValue -> Define a estratégia de geração de valores para a chave primária
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID uuid;

    private String name;
    // @Pattern -> Define um padrão de validação
    @Pattern(regexp = "\\S+", message = "O campo userName Não deve ter espaço")
    private String username;
    // @Email -> Define um padrão de validação
    @Email(message = "O campo Email deve conter um email válido")
    private String email;
    // @Length -> Define um padrão de validação
    @Length(min = 6, message = "O campo Senha deve conter no mínimo 6 caracteres")
    private String password;
    private String description;
    private String curriculum;
    // @CreationTimestamp -> Define a data e hora de criação da entidade
    @CreationTimestamp
    private LocalDateTime createdAt;

}
