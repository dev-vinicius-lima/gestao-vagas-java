package com.vinicius.gestao_vagas.modules.candidate.useCases;

import com.vinicius.gestao_vagas.exceptions.UserFoundException;
import com.vinicius.gestao_vagas.modules.candidate.entity.CandidateEntity;
import com.vinicius.gestao_vagas.modules.candidate.repository.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateCandidateUseCase {

    @Autowired
    private CandidateRepository candidateRepository;

    public CandidateEntity execute(CandidateEntity candidateEntity) {
        this.candidateRepository.findByUserNameOrEmail(candidateEntity.getUserName(), candidateEntity.getEmail()).ifPresent((user) -> {
            throw new UserFoundException();
        });

        return this.candidateRepository.save(candidateEntity);
    }
}
