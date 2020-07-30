package com.example.uerp.core.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import com.fasterxml.jackson.annotation.*;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "pessoa", schema = "uerp")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Pessoa {

    @Id @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String oid;
    
    private String nome;
    private String cpf;
    private LocalDate datanascimento;
    private String email;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "pessoa")
    private List<Telefone> telefone;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "pessoa")
    private List<Endereco> endereco;

    @JsonIgnore
    @OneToOne(fetch = FetchType.LAZY, mappedBy = "pessoa")
    private Usuario usuario;

}