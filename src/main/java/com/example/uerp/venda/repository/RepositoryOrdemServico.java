package com.example.uerp.venda.repository;

import com.example.uerp.venda.entity.OrdemServico;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

@Repository
@RestResource(exported = false)
public interface RepositoryOrdemServico extends CrudRepository<OrdemServico, String> {

}
