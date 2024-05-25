package br.com.fastfood.domain.core;

import java.math.BigDecimal;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.UUID;

public class Pagamento {

    private UUID id;
    private ZonedDateTime dataHora = ZonedDateTime.now(ZoneId.of("America/Sao_Paulo"));
    private Boolean pago = Boolean.FALSE;

    private BigDecimal valorCobrado;

    private Pedido pedido;

    public Pagamento(Boolean pago, BigDecimal valorCobrado, Pedido pedido) {
        this.pago = pago;
        this.valorCobrado = valorCobrado;
        this.pedido = pedido;
    }

    public UUID getId() {
        return id;
    }

    public ZonedDateTime getDataHora() {
        return dataHora;
    }

    public Boolean getPago() {
        return pago;
    }

    public BigDecimal getValorCobrado() {
        return valorCobrado;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}
