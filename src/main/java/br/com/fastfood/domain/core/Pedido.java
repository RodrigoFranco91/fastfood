package br.com.fastfood.domain.core;

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
    private final ZonedDateTime data = ZonedDateTime.now(ZoneId.of("America/Sao_Paulo"));
    private StatusPedido statusPedido = StatusPedido.AGUARDANDO_PAGAMENTO;
    private List<ItemPedido> itensPedido = new ArrayList<>();


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

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
