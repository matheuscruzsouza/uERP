package com.example.uerp.venda.controller;

import com.example.uerp.venda.entity.OrdemServico;
import com.example.uerp.venda.service.ServiceOrdemServico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("ordemservico")
@Tag(name = "Ordem de Serviços", description = "uERP")
public class ControllerOrdemServico {

    @Autowired
    private ServiceOrdemServico service;

    @GetMapping()
    @Operation(summary = "Lista as ordens de serviço", security = @SecurityRequirement(name = "bearerAuth"))
    public Iterable<OrdemServico> getAll() {
        return this.service.getAll();
    }
}
