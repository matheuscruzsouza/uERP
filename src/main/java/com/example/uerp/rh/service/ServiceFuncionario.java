package com.example.uerp.rh.service;

import com.example.uerp.rh.entity.Funcionario;
import com.example.uerp.rh.repository.RepositoryFuncionario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceFuncionario {

    @Autowired
    private RepositoryFuncionario repository;

    public Iterable<Funcionario> getAll() {
        return this.repository.findAll();
    }
}
