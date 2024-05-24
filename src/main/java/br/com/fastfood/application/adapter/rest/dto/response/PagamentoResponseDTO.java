package br.com.fastfood.application.adapter.rest.dto.response;

import java.math.BigDecimal;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.UUID;

public class PagamentoResponseDTO {

    private UUID id;
    private ZonedDateTime dataHora = ZonedDateTime.now(ZoneId.of("America/Sao_Paulo"));
    private Boolean pago = Boolean.FALSE;

    private BigDecimal valorCobrado;

    private PedidoResponseDTO pedido;
}
