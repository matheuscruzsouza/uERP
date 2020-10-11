package com.example.uerp.core.controller;

import java.io.IOException;
import java.util.List;

import com.example.uerp.config.SocketTextHandler;
import com.example.uerp.core.model.Usuario;
import com.example.uerp.core.repository.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.socket.TextMessage;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("usuario")
@Tag(name = "Core API", description = "uERP")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping
    @Operation(summary = "Lista usuarios", security = @SecurityRequirement(name = "bearerAuth"))
    public List<Usuario> listar() {

        try {
            SocketTextHandler.getInstance().broadcast(new TextMessage("Um cliente foi acessado"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return usuarioRepository.findAll();
    }

    @PostMapping
    @Operation(summary = "Cria um novo usuario")
    public ResponseEntity<?> salvar(@RequestBody Usuario usuario) {

        usuario.setSenha(new BCryptPasswordEncoder().encode(usuario.getSenha()));

        return ResponseEntity.status(HttpStatus.OK).body(usuarioRepository.saveAndFlush(usuario));
    }
}