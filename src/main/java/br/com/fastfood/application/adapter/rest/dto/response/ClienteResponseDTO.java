package br.com.fastfood.application.adapter.rest.dto.response;

import br.com.fastfood.domain.core.Cliente;

import java.util.UUID;

public record ClienteResponseDTO(UUID id,String cpf, String nome, String email){
    public ClienteResponseDTO(Cliente cliente) {
        this(cliente.getId(), cliente.getCpf(), cliente.getNome(), cliente.getEmail());
    }
};


