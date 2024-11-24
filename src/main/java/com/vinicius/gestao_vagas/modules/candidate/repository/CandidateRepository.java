package com.vinicius.gestao_vagas.modules.candidate.repository;

import com.vinicius.gestao_vagas.modules.candidate.entity.CandidateEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.Optional;
import java.util.UUID;

@EnableJpaRepositories
public interface CandidateRepository extends JpaRepository<CandidateEntity, UUID> {
    // use o Optional para retornar um tipo CandidateEntity e se não encontrar retorna null ao invés de lançar uma exceção.
    public Optional<CandidateEntity> findByUsernameOrEmail(String username, String email);

    public Optional<CandidateEntity> findByUsername(String username);
}
