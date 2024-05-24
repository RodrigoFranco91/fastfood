package br.com.fastfood.application.adapter.rest.dto.response;

import br.com.fastfood.domain.core.Pedido;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;

public record PedidoResponseDTO(UUID id, BigDecimal total, ZonedDateTime data, String statusPedido,
                                ClienteResponseDTO cliente, List<ItemPedidoResponseDto> itens) {


    public PedidoResponseDTO(Pedido pedidoDomainSalvo) {
        this(pedidoDomainSalvo.getId(), pedidoDomainSalvo.getTotal(), pedidoDomainSalvo.getData(), pedidoDomainSalvo.getStatusPedido().name(),
                new ClienteResponseDTO(pedidoDomainSalvo.getCliente()),
                pedidoDomainSalvo.getItensPedido().stream().map(ItemPedidoResponseDto::new).toList());

    }

}
