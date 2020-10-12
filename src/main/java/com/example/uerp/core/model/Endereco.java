package com.example.uerp.core.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import com.fasterxml.jackson.annotation.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
@Table(name = "endereco", schema = "uerp")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Endereco {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    protected String oid;

    protected String logradouro;
    protected String numero;
    protected String bairro;
    protected String cep;
    protected String tipo;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "oidpessoa")
    protected Pessoa pessoa;

}
