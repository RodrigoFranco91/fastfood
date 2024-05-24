package br.com.fastfood.application.adapter.service;

import br.com.fastfood.application.adapter.rest.dto.response.PagamentoResponseDTO;
import br.com.fastfood.domain.in.PagamentoServicePort;
import br.com.fastfood.domain.out.MercadoPagoPort;
import br.com.fastfood.domain.out.PagamentoRepositoryPort;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PagamentoServiceAdapter implements PagamentoServicePort {

    private PagamentoRepositoryPort pagamentoRepository;
    private MercadoPagoPort mercadoPagoPort;

    public PagamentoServiceAdapter(PagamentoRepositoryPort pagamentoRepository, MercadoPagoPort mercadoPagoPort) {
        this.pagamentoRepository = pagamentoRepository;
        this.mercadoPagoPort = mercadoPagoPort;
    }

    @Override
    public PagamentoResponseDTO pagamento(UUID id) {
        return null;
    }
}
