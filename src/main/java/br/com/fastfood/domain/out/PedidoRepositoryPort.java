package br.com.fastfood.domain.out;

import br.com.fastfood.domain.core.Pedido;

public interface PedidoRepositoryPort {

    Pedido inserePedido(Pedido pedido);
}