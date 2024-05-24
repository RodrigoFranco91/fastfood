package br.com.fastfood.domain.out;

import br.com.fastfood.domain.core.Pedido;
import br.com.fastfood.domain.core.StatusPedido;

import java.util.List;
import java.util.Set;
import java.util.UUID;

public interface PedidoRepositoryPort {

    Pedido inserePedido(Pedido pedido);

    List<Pedido> consultaPedidos();

    Pedido consultaPedidoPorId(UUID id);

    void deletaPedido(UUID id);

    Set<Pedido> consultaPedidoPorStatus(StatusPedido statusPedido);

    Pedido avancaStatusPedido(Pedido pedido);
}
