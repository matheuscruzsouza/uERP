package com.example.uerp.registro.service;

import com.example.uerp.registro.entity.Cliente;
import com.example.uerp.registro.repository.RepositoryCliente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceCliente {

    @Autowired
    private RepositoryCliente repository;

    public Iterable<Cliente> getAll() {
        return this.repository.findAll();
    }
}
