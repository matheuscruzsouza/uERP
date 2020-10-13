package com.example.uerp.rh.controller;

import com.example.uerp.rh.entity.Funcionario;
import com.example.uerp.rh.service.ServiceFuncionario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("funcionario")
@Tag(name = "Recursos Humanos", description = "uERP")
public class ControllerFuncionario {

    @Autowired
    private ServiceFuncionario service;

    @GetMapping()
    @Operation(summary = "Lista funcionarios", security = @SecurityRequirement(name = "bearerAuth"))
    public Iterable<Funcionario> getAll() {
        return this.service.getAll();
    }

    @PostMapping()
    @Operation(summary = "Cria um novo funcionario", security = @SecurityRequirement(name = "bearerAuth"))
    public Funcionario novo(@RequestBody Funcionario funcionario) {
        return this.service.novo(funcionario);
    }

}
