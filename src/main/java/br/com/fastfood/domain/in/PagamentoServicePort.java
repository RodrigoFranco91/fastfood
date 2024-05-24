package br.com.fastfood.domain.in;

import br.com.fastfood.application.adapter.rest.dto.response.PagamentoResponseDTO;

import java.util.UUID;

public interface PagamentoServicePort {

    PagamentoResponseDTO pagamento(UUID id);
}
