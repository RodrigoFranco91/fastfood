package br.com.fastfood.infra.adapter.repositories;

import br.com.fastfood.domain.core.Pedido;
import br.com.fastfood.domain.out.PedidoRepositoryPort;
import br.com.fastfood.infra.adapter.entities.PedidoEntity;
import org.springframework.stereotype.Component;

@Component
public class PedidoRepositoryAdapter implements PedidoRepositoryPort {

    private SpringPedidoRepository springPedidoRepository;

    public PedidoRepositoryAdapter(SpringPedidoRepository springPedidoRepository) {
        this.springPedidoRepository = springPedidoRepository;
    }

    @Override
    public Pedido inserePedido(Pedido pedido) {

        var pedidoEntity = new PedidoEntity(pedido);
        var pedidoSalvo = springPedidoRepository.save(pedidoEntity);

        return pedidoSalvo.toDoamin();
    }
}
