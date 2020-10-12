package com.example.uerp.registro.service;

import com.example.uerp.registro.entity.Marca;
import com.example.uerp.registro.repository.RepositoryMarca;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceMarca {

    @Autowired
    private RepositoryMarca repository;

    public Iterable<Marca> getAll() {
        return this.repository.findAll();
    }
}
