package br.com.fastfood.infra.adapter.entities;

import br.com.fastfood.domain.core.Pedido;
import br.com.fastfood.domain.core.StatusPedido;
import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "pedidos")
public class PedidoEntity implements Serializable {

    public PedidoEntity() {

    }

    public PedidoEntity(Pedido pedido) {
        this.cliente = new ClienteEntity(pedido.getCliente());
        this.total = pedido.getTotal();
        this.data = pedido.getData();
        this.statusPedido = pedido.getStatusPedido();
        this.itensPedido = new ArrayList<>();

        pedido.getItensPedido().forEach(itemPedido -> {
            var itemPedidoEntity = new ItemPedidoEntity(itemPedido);
            itemPedidoEntity.setPedido(this);
            itensPedido.add(itemPedidoEntity);
        });

    }

    public PedidoEntity(Pedido pedido, UUID id) {
        this.id = id;
        this.cliente = new ClienteEntity(pedido.getCliente());
        this.total = pedido.getTotal();
        this.data = pedido.getData();
        this.statusPedido = pedido.getStatusPedido();
        this.itensPedido = new ArrayList<>();

        pedido.getItensPedido().forEach(itemPedido -> {
            var itemPedidoEntity = new ItemPedidoEntity(itemPedido);
            itemPedidoEntity.setId(itemPedido.getId());
            itemPedidoEntity.setPedido(this);
            itensPedido.add(itemPedidoEntity);
        });

    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JdbcTypeCode(SqlTypes.CHAR)
    @Column(columnDefinition = "varchar(36)")
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private ClienteEntity cliente;
    private BigDecimal total;
    private ZonedDateTime data;
    @Enumerated(EnumType.STRING)
    private StatusPedido statusPedido;
    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
    private List<ItemPedidoEntity> itensPedido;


    public UUID getId() {
        return id;
    }

    public ClienteEntity getCliente() {
        return cliente;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public ZonedDateTime getData() {
        return data;
    }

    public StatusPedido getStatusPedido() {
        return statusPedido;
    }

    public List<ItemPedidoEntity> getItensPedido() {
        return itensPedido;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setStatusPedido(StatusPedido statusPedido) {
        this.statusPedido = statusPedido;
    }

    public Pedido toDomain() {
        var itemPedidoList = this.itensPedido.stream().map(ItemPedidoEntity::toDomain).toList();
        return new Pedido(this.id, this.cliente.toDomain(), this.total, this.data, this.statusPedido, itemPedidoList);

    }
}
