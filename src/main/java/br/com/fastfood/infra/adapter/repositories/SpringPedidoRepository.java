package br.com.fastfood.infra.adapter.repositories;

import br.com.fastfood.domain.core.StatusPedido;
import br.com.fastfood.infra.adapter.entities.PedidoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;
import java.util.UUID;

@Repository
public interface SpringPedidoRepository extends JpaRepository<PedidoEntity, UUID> {


    Set<PedidoEntity> findByStatusPedido (StatusPedido statusPedido);
}
