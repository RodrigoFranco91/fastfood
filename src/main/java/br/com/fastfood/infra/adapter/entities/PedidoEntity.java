package br.com.fastfood.infra.adapter.entities;

import br.com.fastfood.domain.core.Cliente;
import br.com.fastfood.domain.core.ItemPedido;
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


    public Pedido toDoamin() {
        List<ItemPedido> intensPedidoList = new ArrayList<>();
        this.itensPedido.forEach(itemPedidoEntity -> {
            intensPedidoList.add(new ItemPedido(itemPedidoEntity));
        });
        return new Pedido(this.id, new Cliente(this.cliente.getId(), this.cliente.getCpf(), this.cliente.getNome(), this.cliente.getEmail(), this.cliente.getSenha()), this.total, this.data, this.statusPedido, intensPedidoList);
    }

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
}
