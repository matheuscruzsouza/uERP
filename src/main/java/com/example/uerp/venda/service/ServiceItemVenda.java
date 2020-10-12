package com.example.uerp.venda.service;

import com.example.uerp.venda.entity.ItemVenda;
import com.example.uerp.venda.repository.ReposiroryItemVenda;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceItemVenda {

    @Autowired
    private ReposiroryItemVenda repository;

    public Iterable<ItemVenda> getAll() {
        return this.repository.findAll();
    }
}
