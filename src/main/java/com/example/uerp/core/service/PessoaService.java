package com.example.uerp.core.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.uerp.core.model.Endereco;
import com.example.uerp.core.model.Pessoa;
import com.example.uerp.core.model.Telefone;
import com.example.uerp.core.repository.EnderecoRepository;
import com.example.uerp.core.repository.PessoaRepository;
import com.example.uerp.core.repository.TelefoneRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository repository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private TelefoneRepository telefoneRepository;

    public Pessoa novaPessoa(Pessoa pessoa) {

        Optional<Pessoa> optPessoa = this.repository.findByCpf(pessoa.getCpf());

        if (optPessoa.isPresent()) {
            return optPessoa.get();
        }

        pessoa = this.repository.save(pessoa);

        pessoa.setTelefone(this.saveTelefones(pessoa));

        pessoa.setEndereco(this.saveEnderecos(pessoa));

        return this.repository.save(pessoa);
    }

    private List<Telefone> saveTelefones(Pessoa pessoa) {

        List<Telefone> telefones = new ArrayList<Telefone>();
        for (Telefone telefone : pessoa.getTelefone()) {

            if (telefone.getOid() == null || telefone.getOid().isEmpty()) {
                telefone.setPessoa(pessoa);
                telefone = this.telefoneRepository.save(telefone);
            }

            telefones.add(telefone);
        }

        return telefones;
    }

    private List<Endereco> saveEnderecos(Pessoa pessoa) {

        List<Endereco> enderecos = new ArrayList<Endereco>();
        for (Endereco endereco : pessoa.getEndereco()) {

            if (endereco.getOid() == null || endereco.getOid().isEmpty()) {
                endereco.setPessoa(pessoa);
                endereco = this.enderecoRepository.save(endereco);
            }

            enderecos.add(endereco);
        }

        return enderecos;
    }

}
