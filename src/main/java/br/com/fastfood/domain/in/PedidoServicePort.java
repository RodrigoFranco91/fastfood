package br.com.fastfood.domain.in;

import br.com.fastfood.application.adapter.rest.dto.request.PedidoDTO;
import br.com.fastfood.application.adapter.rest.dto.response.PedidoResponseDTO;

import java.util.List;
import java.util.Set;
import java.util.UUID;

public interface PedidoServicePort {

    PedidoResponseDTO cadastrarPedido(PedidoDTO pedidoDTO);

    List<PedidoResponseDTO> listar();

    PedidoResponseDTO listarPorId(UUID id);

    void deletaPedido(UUID id);

    Set<PedidoResponseDTO> listarPorStatus(String status);

    PedidoResponseDTO avancaStatusPedido(UUID id);
}
