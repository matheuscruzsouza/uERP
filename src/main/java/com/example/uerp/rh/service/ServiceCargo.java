package com.example.uerp.rh.service;

import com.example.uerp.rh.entity.Cargo;
import com.example.uerp.rh.repository.RepositoryCargo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceCargo {

    @Autowired
    private RepositoryCargo repository;

    public Iterable<Cargo> getAll() {
        return this.repository.findAll();
    }
}
