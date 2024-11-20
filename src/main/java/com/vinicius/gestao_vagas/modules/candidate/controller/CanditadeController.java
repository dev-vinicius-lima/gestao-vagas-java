package com.vinicius.gestao_vagas.modules.candidate.controller;


import com.vinicius.gestao_vagas.modules.candidate.entity.CandidateEntity;
import com.vinicius.gestao_vagas.modules.candidate.repository.CandidateRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/candidate")
public class CanditadeController {
    @Autowired
    private CandidateRepository candidateRepository;


    @PostMapping
    public CandidateEntity createCandidate(@Valid @RequestBody CandidateEntity candidateEntity) {
        return this.candidateRepository.save(candidateEntity);
    }
}
