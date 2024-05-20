package br.com.fastfood.application.adapter.rest.dto.response;

import br.com.fastfood.domain.core.Pedido;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;

public record PedidoResponseDTO(UUID id, BigDecimal total, ZonedDateTime data, String statusPedido,
                                ClienteResponseDTO cliente, List<ItemPedidoResponseDto> itens) {

    public PedidoResponseDTO(Pedido pedidoCriado, ClienteResponseDTO clienteResponseDTO, List<ItemPedidoResponseDto> itensPedidoResponseDto) {
        this(pedidoCriado.getId(), pedidoCriado.getTotal(), pedidoCriado.getData(), pedidoCriado.getStatusPedido().name(), clienteResponseDTO, itensPedidoResponseDto);
    }
}
