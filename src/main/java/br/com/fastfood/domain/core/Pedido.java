package br.com.fastfood.domain.core;

import java.math.BigDecimal;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;

public class Pedido {

    private UUID id;
    private Cliente cliente;
    private BigDecimal total;
    private final ZonedDateTime data = ZonedDateTime.now(ZoneId.of("America/Sao_Paulo"));
    private StatusPedido statusPedido;
    private List<ItemPedido> itensPedido;


    public void calculaTotal(){

        itensPedido.forEach(itemPedido -> {
            total = total.add(itemPedido.calculaTotal());
        });
    }
}
