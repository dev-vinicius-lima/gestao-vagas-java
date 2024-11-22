package com.vinicius.gestao_vagas.modules.company.useCases;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.vinicius.gestao_vagas.modules.company.dto.AuthCompanyDTO;
import com.vinicius.gestao_vagas.modules.company.repositories.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.naming.AuthenticationException;

@Service
public class AuthCompanyUseCase {
    @Value("${security.token.secret}")
    private String secretKey;
    // injeção de dependência do repositório de empresas
    @Autowired
    private CompanyRepository companyRepository;

    // injeção de dependência do PasswordEncoder para criptografar a senha
    @Autowired
    private PasswordEncoder passwordEncoder;

    // recebendo por parametro o username e a senha do DTO.
    public String execute(AuthCompanyDTO authCompanyDTO) throws AuthenticationException {
        // verificar se o usuário existe no banco
        var company = this.companyRepository.findByUsername(authCompanyDTO.getUsername()).orElseThrow(
                () -> new UsernameNotFoundException("Username/password incorrect"));
        // verificar a senha do usuário
        // metodo matches -> compara a senha nao criptografada com a senha criptografada.
        boolean passwordMatches = this.passwordEncoder.matches(authCompanyDTO.getPassword(), company.getPassword());
        if (!passwordMatches) {
            throw new AuthenticationException();
        }
        // gerar o token de autenticação
        // tipo de algoritmo de criptografia HMAC256
        Algorithm algorithm = Algorithm.HMAC256(secretKey);
        // gerar o token com o id da empresa como subject e o algoritmo de criptografia HMAC256
        // emissor do token -> javagas
        var token = JWT.create().withIssuer("javagas").withSubject(company.getId().toString()).sign(algorithm);
        return token;
    }
}
