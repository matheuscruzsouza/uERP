package com.example.uerp.venda.service;

import com.example.uerp.venda.entity.OrdemServico;
import com.example.uerp.venda.repository.RepositoryOrdemServico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceOrdemServico {

    @Autowired
    private RepositoryOrdemServico repository;

    public Iterable<OrdemServico> getAll() {
        return this.repository.findAll();
    }

}
