package br.com.fastfood.domain.core;

import br.com.fastfood.infra.adapter.entities.PedidoEntity;

import java.math.BigDecimal;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Pedido {

    private UUID id;
    private Cliente cliente;
    private BigDecimal total = BigDecimal.ZERO;
    private final ZonedDateTime data;
    private StatusPedido statusPedido;
    private List<ItemPedido> itensPedido;

    public Pedido(UUID id, Cliente cliente, BigDecimal total, ZonedDateTime data, StatusPedido statusPedido, List<ItemPedido> itensPedido) {
        this.id = id;
        this.cliente = cliente;
        this.total = total;
        this.data = data;
        this.statusPedido = statusPedido;
        this.itensPedido = itensPedido;
    }

    public Pedido(Cliente cliente, List<ItemPedido> itensPedido) {
        this.cliente = cliente;
        this.itensPedido = itensPedido;
        this.data = ZonedDateTime.now(ZoneId.of("America/Sao_Paulo"));
        this.statusPedido = StatusPedido.AGUARDANDO_PAGAMENTO;
        calculaTotal();

        itensPedido.forEach(itemPedido -> {
            itemPedido.setPedido(this);
        });

    }

    public Pedido(PedidoEntity pedidoEntity) {
        this.id = pedidoEntity.getId();
        this.cliente = new Cliente(pedidoEntity.getCliente());
        this.total = pedidoEntity.getTotal();
        this.data = pedidoEntity.getData();
        this.statusPedido = pedidoEntity.getStatusPedido();
        this.itensPedido = new ArrayList<>();

        pedidoEntity.getItensPedido().forEach(itemPedidoEntity -> {
            itensPedido.add(new ItemPedido(itemPedidoEntity));
        });
    }

    public void calculaTotal() {

        itensPedido.forEach(itemPedido -> {
            total = total.add(itemPedido.calculaTotal());
        });
    }

    public UUID getId() {
        return id;
    }

    public Cliente getCliente() {
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

    public List<ItemPedido> getItensPedido() {
        return itensPedido;
    }
}
