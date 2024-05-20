package br.com.fastfood.domain.core;

import br.com.fastfood.infra.adapter.entities.ItemPedidoEntity;

import java.math.BigDecimal;
import java.util.UUID;

public class ItemPedido {

    public ItemPedido(Produto produto, Integer quantidadeDoItem, BigDecimal precoAtualDoIem) {
        this.produto = produto;
        this.quantidadeDoItem = quantidadeDoItem;
        this.precoAtualDoIem = precoAtualDoIem;
    }

    public ItemPedido(ItemPedidoEntity itemPedidoEntity) {
        var pedido = new Pedido(itemPedidoEntity.getPedido());
        var produto = new Produto(itemPedidoEntity.getProduto());
        this.id = itemPedidoEntity.getId();
        this.pedido = pedido;
        this.produto = produto;
        this.quantidadeDoItem = itemPedidoEntity.getQuantidadeDoItem();
        this.precoAtualDoIem = itemPedidoEntity.getPrecoAtualDoIem();
    }

    private UUID id;
    private Pedido pedido;
    private Produto produto;
    private Integer quantidadeDoItem;
    private BigDecimal precoAtualDoIem;

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
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

    public BigDecimal getPrecoAtualDoIem() {
        return precoAtualDoIem;
    }

    public BigDecimal calculaTotal() {
        return precoAtualDoIem.multiply(BigDecimal.valueOf(quantidadeDoItem));
    }
}
