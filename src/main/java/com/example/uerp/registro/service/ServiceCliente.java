package com.example.uerp.registro.service;

import com.example.uerp.core.service.PessoaService;
import com.example.uerp.registro.entity.Cliente;
import com.example.uerp.registro.repository.RepositoryCliente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class ServiceCliente {

    @Autowired
    private RepositoryCliente repository;

    @Autowired
    private PessoaService pessoaService;

    public Iterable<Cliente> getAll() {
        return this.repository.findAll();
    }

    public Cliente novo(Cliente cliente) {

        cliente.setPessoa(this.pessoaService.novaPessoa(cliente.getPessoa()));
        cliente.setSenha(new BCryptPasswordEncoder().encode(cliente.getSenha()));

        return this.repository.save(cliente);
    }
}
