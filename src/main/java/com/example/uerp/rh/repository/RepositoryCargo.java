package com.example.uerp.rh.repository;

import com.example.uerp.rh.entity.Cargo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

@Repository
@RestResource(exported = false)
public interface RepositoryCargo extends CrudRepository<Cargo, String> {

}
