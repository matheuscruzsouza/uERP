package com.example.uerp.core.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "usuario", schema = "uerp")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Usuario {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    protected String oid;

    protected String login;

    @JsonProperty(access = Access.WRITE_ONLY)
    protected String senha;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "oidpessoa")
    protected Pessoa pessoa;

}