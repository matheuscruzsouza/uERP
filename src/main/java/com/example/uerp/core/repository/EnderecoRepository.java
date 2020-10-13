package com.example.uerp.core.repository;

import com.example.uerp.core.model.Endereco;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

@Repository
@RestResource(exported = false)
public interface EnderecoRepository extends JpaRepository<Endereco, String> {

}
