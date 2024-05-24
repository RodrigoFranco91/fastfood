package br.com.fastfood.domain.out;

import br.com.fastfood.infra.adapter.mercadopago.ResponseMercadoPagoDTO;

import java.util.UUID;

public interface MercadoPagoPort {

    ResponseMercadoPagoDTO efetivaPagamento(UUID id);
}
