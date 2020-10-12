package com.example.uerp.registro.controller;

import com.example.uerp.registro.entity.Servico;
import com.example.uerp.registro.service.ServiceServico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("servico")
@Tag(name = "Registro", description = "uERP")
public class ControllerServico {

    @Autowired
    private ServiceServico service;

    @GetMapping()
    @Operation(summary = "Lista serviços", security = @SecurityRequirement(name = "bearerAuth"))
    public Iterable<Servico> getAll() {
        return this.service.getAll();
    }

}
