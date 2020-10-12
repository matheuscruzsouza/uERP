package com.example.uerp.venda.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.example.uerp.registro.entity.Cliente;
import com.example.uerp.rh.entity.Funcionario;

import org.hibernate.annotations.GenericGenerator;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@Table(name = "venda_produto", schema = "venda")
public class VendaProduto {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String oid;

    @ManyToOne(fetch = FetchType.LAZY)
    private Funcionario atendente;

    @ManyToOne(fetch = FetchType.LAZY)
    private Cliente cliente;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "itens_venda")
    private List<ItemVenda> itens;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "itens_servico")
    private List<itemServico> servicos;

    private LocalDateTime data;

    private BigDecimal total;

}
