package com.example.uerp.registro.repository;

import com.example.uerp.registro.entity.Cliente;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

@Repository
@RestResource(exported = false)
public interface RepositoryCliente extends CrudRepository<Cliente, String> {

}
