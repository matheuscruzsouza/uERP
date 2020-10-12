package com.example.uerp.registro.service;

import com.example.uerp.registro.entity.Servico;
import com.example.uerp.registro.repository.RepositoryServico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceServico {

    @Autowired
    private RepositoryServico repository;

    public Iterable<Servico> getAll() {
        return this.repository.findAll();
    }
}
