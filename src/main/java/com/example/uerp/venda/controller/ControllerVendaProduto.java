package com.example.uerp.venda.controller;

import com.example.uerp.venda.entity.VendaProduto;
import com.example.uerp.venda.service.ServiceVendaProduto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("venda")
@Tag(name = "Vendas", description = "uERP")
public class ControllerVendaProduto {

    @Autowired
    private ServiceVendaProduto service;

    @GetMapping()
    @Operation(summary = "Lista vendas", security = @SecurityRequirement(name = "bearerAuth"))
    public Iterable<VendaProduto> getAll() {
        return this.service.getAll();
    }

}
