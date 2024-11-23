package com.vinicius.gestao_vagas.modules.candidate.repository;

import com.vinicius.gestao_vagas.modules.candidate.entity.CandidateEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface CandidateRepository extends JpaRepository<CandidateEntity, UUID> {
    // use o Optional para retornar um tipo CandidateEntity e se não encontrar retorna null ao invés de lançar uma exceção.
    Optional<CandidateEntity> findByUserNameOrEmail(String userName, String email);

    Optional<CandidateEntity> findByUsername(String usarname);
}
