package br.com.fastfood.application.adapter.rest.dto.request;

import java.util.List;

public record PedidoDTO(String cpfCliente, List<ItensPedidoDTO> itens) {
}
