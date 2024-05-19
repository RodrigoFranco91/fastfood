package br.com.fastfood.infra.adapter.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "item_pedido")
public class ItemPedidoEntity {

    public ItemPedidoEntity() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JdbcTypeCode(SqlTypes.CHAR)
    @Column(columnDefinition = "varchar(36)")
    private UUID id;

    @ManyToOne()
    private PedidoEntity pedido;

    @ManyToOne
    private ProdutoEntity produto;
    private Integer quantidadeDoItem;
    private BigDecimal precoAtualDoIem;

    public BigDecimal calculaTotal() {
        return precoAtualDoIem.multiply(BigDecimal.valueOf(quantidadeDoItem));
    }
}
