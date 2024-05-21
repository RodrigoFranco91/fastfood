package br.com.fastfood.domain.in;

import br.com.fastfood.application.adapter.rest.dto.request.PedidoDTO;
import br.com.fastfood.application.adapter.rest.dto.response.PedidoResponseDTO;

public interface PedidoServicePort {

    void cadastrarPedido(PedidoDTO pedidoDTO);
}
