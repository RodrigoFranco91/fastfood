package br.com.fastfood.application.adapter.rest.dto.response;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;

public record PedidoResponseDTO(UUID id, BigDecimal total, ZonedDateTime data, String statusPedido, ClienteResponseDTO cliente, List<ItemPedidoResponseDto> itens) {
}


