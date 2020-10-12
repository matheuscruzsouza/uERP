package com.example.uerp.venda.service;

import com.example.uerp.venda.entity.itemServico;
import com.example.uerp.venda.repository.RepositoryItemServico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceItemServico {

    @Autowired
    private RepositoryItemServico repository;

    public Iterable<itemServico> getAll() {
        return this.repository.findAll();
    }

}
