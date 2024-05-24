package br.com.fastfood.infra.adapter.repositories;

import br.com.fastfood.infra.adapter.entities.PagamentoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SpringPagamentoRepository extends JpaRepository<PagamentoEntity, UUID> {
}
