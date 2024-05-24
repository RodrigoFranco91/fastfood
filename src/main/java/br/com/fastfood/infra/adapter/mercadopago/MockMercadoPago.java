package br.com.fastfood.infra.adapter.mercadopago;

import br.com.fastfood.domain.out.MercadoPagoPort;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class MockMercadoPago implements MercadoPagoPort {
    @Override
    public ResponseMercadoPagoDTO efetivaPagamento(UUID id) {
        return new ResponseMercadoPagoDTO(Boolean.TRUE, "Pagamento do pedido: " + id + " efetuado com sucesso.");
    }
}
