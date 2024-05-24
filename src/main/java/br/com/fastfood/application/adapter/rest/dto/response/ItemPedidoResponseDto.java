package br.com.fastfood.application.adapter.rest.dto.response;

import br.com.fastfood.domain.core.ItemPedido;

import java.math.BigDecimal;

public record ItemPedidoResponseDto(String produto, Integer quantidadeDoItem, BigDecimal precoAtualDoIem) {

    public ItemPedidoResponseDto (ItemPedido itemPedido){
        this(itemPedido.getProduto().getNome(), itemPedido.getQuantidadeDoItem(), itemPedido.getPrecoAtualDoIem());
    }
}
