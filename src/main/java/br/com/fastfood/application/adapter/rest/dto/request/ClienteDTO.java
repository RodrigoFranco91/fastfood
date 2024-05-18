package br.com.fastfood.application.adapter.rest.dto.request;

import java.util.UUID;

public record ClienteDTO(String cpf, String nome, String email, String senha){

};