package br.com.fastfood.infra.adapter.repositories;


import br.com.fastfood.application.adapter.rest.dto.response.ProdutoResponseDTO;
import br.com.fastfood.domain.core.Produto;
import br.com.fastfood.domain.out.ProdutoRepositoryPort;
import br.com.fastfood.infra.adapter.entities.ProdutoEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import java.util.Set;
import java.util.UUID;
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
        var entitySalvo = springProdutoRepository.save(entity);

        return entitySalvo.toDomain();
    }

    @Override
    public Set<Produto> pegarProdutos() {

        var produtosEntities = springProdutoRepository.findAll();
        return produtosEntities.stream().map(ProdutoEntity::toDomain).collect(Collectors.toSet());
    }

    @Override
    public Produto pegarProduto(UUID id) {
        var produtoEntity = springProdutoRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return produtoEntity.toDomain();
    }

    @Override
    public void removerProduto(UUID id) {
        var produtoEntity = springProdutoRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        springProdutoRepository.delete(produtoEntity);

    }

    @Override
    public Produto atualizarProduto(Produto produto) {
        var produtoEntity = springProdutoRepository.findById(produto.getId()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        produtoEntity.setCategoria(produto.getCategoria());
        produtoEntity.setNome(produto.getNome());
        produtoEntity.setPreco(produto.getPreco());
        produtoEntity.setImagem(produto.getImagem());
        produtoEntity.setDescricao(produto.getDescricao());
        springProdutoRepository.save(produtoEntity);

        return produtoEntity.toDomain();
    }

}
