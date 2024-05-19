package br.com.fastfood.application.adapter.service;

import br.com.fastfood.application.adapter.rest.dto.request.PedidoDTO;
import br.com.fastfood.application.adapter.rest.dto.response.PedidoResponseDTO;
import br.com.fastfood.domain.in.PedidoServicePort;
import br.com.fastfood.domain.out.PedidoRepositoryPort;
import org.springframework.stereotype.Service;

@Service
public class PedidoServiceAdapter implements PedidoServicePort {

    private PedidoRepositoryPort pedidoRepository;

    public PedidoServiceAdapter(PedidoRepositoryPort pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    @Override
    public PedidoResponseDTO cadastrarPedido(PedidoDTO pedidoDTO) {
        return null;
    }
}
