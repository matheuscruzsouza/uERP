package com.example.uerp.rh.service;

import com.example.uerp.core.service.PessoaService;
import com.example.uerp.rh.entity.Funcionario;
import com.example.uerp.rh.repository.RepositoryFuncionario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class ServiceFuncionario {

    @Autowired
    private RepositoryFuncionario repository;

    @Autowired
    private PessoaService pessoaService;

    @Autowired
    private ServiceCargo cargoService;

    public Iterable<Funcionario> getAll() {
        return this.repository.findAll();
    }

    public Funcionario novo(Funcionario funcionario) {

        funcionario.setPessoa(this.pessoaService.novaPessoa(funcionario.getPessoa()));
        funcionario.setSenha(new BCryptPasswordEncoder().encode(funcionario.getSenha()));
        funcionario.setCargo(this.cargoService.novo(funcionario.getCargo()));

        return this.repository.save(funcionario);
    }
}
