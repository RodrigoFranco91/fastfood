package br.com.fastfood.infra.adapter.entities;

import br.com.fastfood.domain.core.ItemPedido;
import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "item_pedido")
public class ItemPedidoEntity implements Serializable {

    public ItemPedidoEntity() {
    }

    public ItemPedidoEntity(ItemPedido itemPedido) {

        this.produto = new ProdutoEntity(itemPedido.getProduto());
        this.quantidadeDoItem = itemPedido.getQuantidadeDoItem();
        this.precoAtualDoItem = itemPedido.getPrecoAtualDoItem();

    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JdbcTypeCode(SqlTypes.CHAR)
    @Column(columnDefinition = "varchar(36)")
    private UUID id;

    @ManyToOne
    private PedidoEntity pedido;

    @ManyToOne
    private ProdutoEntity produto;
    private Integer quantidadeDoItem;
    private BigDecimal precoAtualDoItem;

    public UUID getId() {
        return id;
    }

    public PedidoEntity getPedido() {
        return pedido;
    }

    public ProdutoEntity getProduto() {
        return produto;
    }

    public Integer getQuantidadeDoItem() {
        return quantidadeDoItem;
    }

    public BigDecimal getPrecoAtualDoItem() {
        return precoAtualDoItem;
    }

    public void setPedido(PedidoEntity pedido) {
        this.pedido = pedido;
    }

    public ItemPedido toDomain() {
        return new ItemPedido(this.id, this.produto.toDomain(), this.quantidadeDoItem, this.precoAtualDoItem);
    }

    public void setId(UUID id) {
        this.id = id;
    }
}
