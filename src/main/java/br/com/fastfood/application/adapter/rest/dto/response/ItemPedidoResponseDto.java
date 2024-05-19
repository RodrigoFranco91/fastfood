package br.com.fastfood.application.adapter.rest.dto.response;

import java.math.BigDecimal;

public record ItemPedidoResponseDto(String produto, Integer quantidadeDoItem, BigDecimal precoAtualDoIem) {

}
