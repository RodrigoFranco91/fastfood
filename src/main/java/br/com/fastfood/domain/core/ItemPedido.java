package br.com.fastfood.domain.core;

import java.math.BigDecimal;
import java.util.UUID;

public class ItemPedido {

    private UUID id;
    private Pedido pedido;
    private Produto produto;
    private Integer quantidadeDoItem;
    private BigDecimal precoAtualDoIem;

    public BigDecimal calculaTotal() {
        return precoAtualDoIem.multiply(BigDecimal.valueOf(quantidadeDoItem));
    }
}
