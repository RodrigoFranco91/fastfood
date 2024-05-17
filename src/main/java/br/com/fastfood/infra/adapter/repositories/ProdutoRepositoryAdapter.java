package br.com.fastfood.infra.adapter.repositories;


import br.com.fastfood.domain.core.Produto;
import br.com.fastfood.domain.out.ProdutoRepositoryPort;
import br.com.fastfood.infra.adapter.entities.ProdutoEntity;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;


@Component
public class ProdutoRepositoryAdapter implements ProdutoRepositoryPort {

    private SpringProdutoRepository springProdutoRepository;

    public ProdutoRepositoryAdapter(SpringProdutoRepository springProdutoRepository) {
        this.springProdutoRepository = springProdutoRepository;
    }

    @Override
    public Produto insertProduto(Produto produto) {

        var entity = new ProdutoEntity(produto);
        var entityComId = springProdutoRepository.save(entity);

        return entityComId.toDomain();
    }

    @Override
    public Set<Produto> pegarProdutos() {

        var produtosEntities = springProdutoRepository.findAll();
        return produtosEntities.stream().map(ProdutoEntity::toDomain).collect(Collectors.toSet());
    }
}
