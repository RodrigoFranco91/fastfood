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
}
