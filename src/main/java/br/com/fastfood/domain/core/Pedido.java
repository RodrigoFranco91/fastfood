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
    private ZonedDateTime data = ZonedDateTime.now(ZoneId.of("America/Sao_Paulo"));
    private StatusPedido statusPedido = StatusPedido.AGUARDANDO_PAGAMENTO;
    private List<ItemPedido> itensPedido = new ArrayList<>();

    public Pedido() {
    }

    public Pedido(UUID id, Cliente cliente, BigDecimal total, ZonedDateTime data, StatusPedido statusPedido, List<ItemPedido> itemPedidoList) {
        this.id = id;
        this.cliente = cliente;
        this.total = total;
        this.data = data;
        this.statusPedido = statusPedido;
        this.itensPedido = itemPedidoList;
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

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void avancaStatus() {
        var statusAtual = this.statusPedido.name();

        if(statusAtual.equals("RECEBIDO")){
            this.statusPedido = StatusPedido.EM_PREPARACAO;
        }
        if(statusAtual.equals("EM_PREPARACAO")){
            this.statusPedido = StatusPedido.PRONTO;
        }
        if(statusAtual.equals("PRONTO")){
            this.statusPedido = StatusPedido.FINALIZADO;
        }
    }
}
