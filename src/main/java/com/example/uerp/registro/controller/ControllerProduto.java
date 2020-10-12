package com.example.uerp.registro.controller;

import com.example.uerp.registro.entity.Produto;
import com.example.uerp.registro.service.ServiceProduto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("produto")
@Tag(name = "Registro", description = "uERP")
public class ControllerProduto {

    @Autowired
    private ServiceProduto service;

    @GetMapping()
    @Operation(summary = "Lista produtos", security = @SecurityRequirement(name = "bearerAuth"))
    public Iterable<Produto> getAll() {
        return this.service.getAll();
    }

}
