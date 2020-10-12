package com.example.uerp.core.repository;

import com.example.uerp.core.model.Usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

@Repository
@RestResource(exported = false)
public interface UsuarioRepository extends JpaRepository<Usuario, String> {

    Usuario findByLogin(String login);

}