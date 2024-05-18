package br.com.fastfood.application.adapter.service;


import br.com.fastfood.application.adapter.rest.dto.request.ProdutoDTO;
import br.com.fastfood.application.adapter.rest.dto.response.ProdutoResponseDTO;
import br.com.fastfood.domain.core.Produto;
import br.com.fastfood.domain.in.ProdutoServicePort;
import br.com.fastfood.domain.out.ProdutoRepositoryPort;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ProdutoServiceAdapter implements ProdutoServicePort {

    private ProdutoRepositoryPort produtoRepository;

    public ProdutoServiceAdapter(ProdutoRepositoryPort produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @Override
    public ProdutoResponseDTO cadastraProduto(ProdutoDTO produtoDTO) {

        var produto = new Produto(produtoDTO);
        var produtoSalvo = produtoRepository.insertProduto(produto);
        return new ProdutoResponseDTO(produtoSalvo);

    }

    @Override
    public Set<ProdutoResponseDTO> listarTodosProdutos() {

        Set<Produto> produtos = produtoRepository.pegarProdutos();
        return produtos.stream().map(ProdutoResponseDTO::new).collect(Collectors.toSet());
    }

    @Override
    public ProdutoResponseDTO listarProdutoPorId(UUID id) {

        var produto = produtoRepository.pegarProduto(id);
        return new ProdutoResponseDTO(produto);
    }

    @Override
    public void deletarProduto(UUID id) {
        produtoRepository.removerProduto(id);
    }

    @Override
    public ProdutoResponseDTO atualizarProduto(UUID id, ProdutoDTO produtoDTO) {
        var produto = new Produto(id, produtoDTO);
        var produtoAtualizado = produtoRepository.atualizarProduto(produto);
        return new ProdutoResponseDTO(produtoAtualizado);
    }
}
