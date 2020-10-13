package com.example.uerp.core.repository;

import java.util.Optional;

import com.example.uerp.core.model.Pessoa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

@Repository
@RestResource(exported = false)
public interface PessoaRepository extends JpaRepository<Pessoa, String> {

    Optional<Pessoa> findByCpf(String cpf);

}
