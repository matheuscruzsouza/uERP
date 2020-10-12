package com.example.uerp.registro.controller;

import com.example.uerp.registro.entity.Cliente;
import com.example.uerp.registro.service.ServiceCliente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("cliente")
@Tag(name = "Registro", description = "uERP")
public class ControllerCliente {

    @Autowired
    private ServiceCliente service;

    @GetMapping()
    @Operation(summary = "Lista clientes", security = @SecurityRequirement(name = "bearerAuth"))
    public Iterable<Cliente> getAll() {
        return this.service.getAll();
    }
}
