package com.vinicius.gestao_vagas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.vinicius.gestao_vagas.modules")
public class GestaoVagasApplication {

    public static void main(String[] args) {
        SpringApplication.run(GestaoVagasApplication.class, args);
    }

}
