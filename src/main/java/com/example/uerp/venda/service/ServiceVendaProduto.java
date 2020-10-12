package com.example.uerp.venda.service;

import com.example.uerp.venda.entity.VendaProduto;
import com.example.uerp.venda.repository.RepositoryVendaProduto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceVendaProduto {

    @Autowired
    private RepositoryVendaProduto repository;

    public Iterable<VendaProduto> getAll() {
        return this.repository.findAll();
    }
}
