package br.com.fastfood.infra.adapter.repositories;


import br.com.fastfood.domain.core.Categoria;
import br.com.fastfood.infra.adapter.entities.ProdutoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;
import java.util.UUID;

@Repository
public interface SpringProdutoRepository extends JpaRepository<ProdutoEntity, UUID> {

    Set<ProdutoEntity> findByCategoria (Categoria categoria);
}
