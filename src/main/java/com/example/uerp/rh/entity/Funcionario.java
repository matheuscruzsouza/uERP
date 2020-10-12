package com.example.uerp.rh.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.example.uerp.core.model.Usuario;

import org.hibernate.annotations.GenericGenerator;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@Table(name = "funcionario", schema = "rh")
public class Funcionario extends Usuario {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String oid;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "oidcargo")
    private Cargo cargo;

    private BigDecimal salario;

    private LocalDate admissao;

    private LocalDate desligamento;
}
