package br.com.fastfood.domain.core;

import java.math.BigDecimal;
import java.util.UUID;

public class ItemPedido {


    private UUID id;
    private Pedido pedido;
    private Produto produto;
    private Integer quantidadeDoItem;
    private BigDecimal precoAtualDoItem;

    public ItemPedido() {
    }

    public ItemPedido(Produto produtoDomain, Integer quantidade, BigDecimal preco) {
        this.produto = produtoDomain;
        this.quantidadeDoItem = quantidade;
        this.precoAtualDoItem = preco;
    }


    public ItemPedido(UUID id, Produto produto, Integer quantidadeDoItem, BigDecimal precoAtualDoItem) {
        this.id = id;
        this.produto = produto;
        this.quantidadeDoItem = quantidadeDoItem;
        this.precoAtualDoItem = precoAtualDoItem;
    }

    public UUID getId() {
        return id;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public Produto getProduto() {
        return produto;
    }

    public Integer getQuantidadeDoItem() {
        return quantidadeDoItem;
    }

    public BigDecimal getPrecoAtualDoItem() {
        return precoAtualDoItem;
    }

    public BigDecimal calculaTotal() {
        return precoAtualDoItem.multiply(BigDecimal.valueOf(quantidadeDoItem));
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }
}
