package br.com.fastfood.infra.adapter.repositories;

import br.com.fastfood.domain.core.Pedido;
import br.com.fastfood.domain.core.StatusPedido;
import br.com.fastfood.domain.out.PedidoRepositoryPort;
import br.com.fastfood.infra.adapter.entities.PedidoEntity;
import jakarta.persistence.EntityManager;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class PedidoRepositoryAdapter implements PedidoRepositoryPort {

    private SpringPedidoRepository springPedidoRepository;


    private EntityManager entityManager;

    public PedidoRepositoryAdapter(SpringPedidoRepository springPedidoRepository, EntityManager entityManager) {
        this.springPedidoRepository = springPedidoRepository;
        this.entityManager = entityManager;
    }

    @Override
    public Pedido inserePedido(Pedido pedido) {

        var pedidoEntity = new PedidoEntity(pedido);
        var pedidoEntitySalvo = springPedidoRepository.save(pedidoEntity);
        return pedidoEntitySalvo.toDomain();
    }

    @Override
    public List<Pedido> consultaPedidos() {

        var pedidoEntityList = springPedidoRepository.findAll();
        return pedidoEntityList.stream().map(PedidoEntity::toDomain).collect(Collectors.toList());
    }

    @Override
    public Pedido consultaPedidoPorId(UUID id) {

        var pedidoEntity = springPedidoRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Não existe pedido cujo ID é: " + id));
        return pedidoEntity.toDomain();
    }

    @Override
    public void deletaPedido(UUID id) {

        springPedidoRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Não existe pedido cujo ID é: " + id));
        springPedidoRepository.deleteById(id);

    }

    @Override
    public Set<Pedido> consultaPedidoPorStatus(StatusPedido statusPedido) {
        return springPedidoRepository.findByStatusPedido(statusPedido).stream().map(PedidoEntity::toDomain).collect(Collectors.toSet());
    }

    @Override
    public Pedido avancaStatusPedido(Pedido pedido) {

        var pedidoEntity = new PedidoEntity(pedido, pedido.getId());
        var pedidoEntityComStatusAtualizado = springPedidoRepository.save(pedidoEntity);
        return pedidoEntityComStatusAtualizado.toDomain();
    }


}
