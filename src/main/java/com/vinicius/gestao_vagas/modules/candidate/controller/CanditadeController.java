package com.vinicius.gestao_vagas.modules.candidate.controller;


import com.vinicius.gestao_vagas.exceptions.UserFoundException;
import com.vinicius.gestao_vagas.modules.candidate.entity.CandidateEntity;
import com.vinicius.gestao_vagas.modules.candidate.repository.CandidateRepository;
import com.vinicius.gestao_vagas.modules.candidate.useCases.CreateCandidateUseCase;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/candidate")
public class CanditadeController {

    @Autowired
    private CreateCandidateUseCase createCandidateUseCase;

    @PostMapping
    public ResponseEntity<Object> createCandidate(@Valid @RequestBody CandidateEntity candidateEntity) {
        try {
            var result = this.createCandidateUseCase.execute(candidateEntity);
            return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
