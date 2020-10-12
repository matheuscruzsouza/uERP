package com.example.uerp.registro.repository;

import com.example.uerp.registro.entity.Servico;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

@Repository
@RestResource(exported = false)
public interface RepositoryServico extends CrudRepository<Servico, String> {

}
