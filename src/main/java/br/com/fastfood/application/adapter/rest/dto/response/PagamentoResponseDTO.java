package br.com.fastfood.application.adapter.rest.dto.response;

import br.com.fastfood.domain.core.Pagamento;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.UUID;

public record PagamentoResponseDTO(UUID id, ZonedDateTime dataHora, Boolean pago, BigDecimal valorCobrado,
                                   PedidoResponseDTO pedido) {
    public PagamentoResponseDTO(Pagamento pagamento) {
        this(pagamento.getId(), pagamento.getDataHora(), pagamento.getPago(), pagamento.getValorCobrado(), new PedidoResponseDTO(pagamento.getPedido()));
    }
}
