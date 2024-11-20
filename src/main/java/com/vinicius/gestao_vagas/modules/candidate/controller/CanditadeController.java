package com.vinicius.gestao_vagas.modules.candidate.controller;


import com.vinicius.gestao_vagas.modules.candidate.entity.CandidateEntity;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/candidate")
public class CanditadeController {


    @PostMapping
    public void createCandidate(@Valid @RequestBody CandidateEntity candidateEntity) {
        System.out.print("Candidato: ");
        System.out.println(candidateEntity.getEmail());
    }

}
