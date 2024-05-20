package br.com.fastfood.domain.core;

import br.com.fastfood.application.adapter.rest.dto.request.ClienteDTO;
import br.com.fastfood.infra.adapter.entities.ClienteEntity;

import java.util.UUID;

public class Cliente {

    public Cliente(UUID id, String cpf, String nome, String email, String senha) {
        this.id = id;
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    public Cliente(ClienteDTO clienteDTO) {
        this.cpf = clienteDTO.cpf();
        this.nome = clienteDTO.nome();
        this.email = clienteDTO.email();
        this.senha = clienteDTO.senha();
    }

    private UUID id;
    private String cpf;
    private String nome;
    private String email;
    private String senha;

    public Cliente(ClienteEntity clienteEntity) {
        this.id = clienteEntity.getId();
        this.cpf = clienteEntity.getCpf();
        this.nome = clienteEntity.getNome();
        this.email = clienteEntity.getEmail();
        this.senha = clienteEntity.getSenha();
    }

    public UUID getId() {
        return id;
    }

    public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
