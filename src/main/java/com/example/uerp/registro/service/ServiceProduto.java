package com.example.uerp.registro.service;

import com.example.uerp.registro.entity.Produto;
import com.example.uerp.registro.repository.RepositoryProduto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceProduto {

    @Autowired
    private RepositoryProduto repository;

    public Iterable<Produto> getAll() {
        return this.repository.findAll();
    }
}
