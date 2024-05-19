package br.com.fastfood.application.adapter.rest.dto.request;

import java.util.UUID;

public record ItensPedidoDTO(UUID produtoId, Integer quantidade) {
}
