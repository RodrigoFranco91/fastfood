package br.com.fastfood.application.adapter.rest.dto.response;


import br.com.fastfood.application.adapter.rest.dto.request.CategoriaDTO;
import br.com.fastfood.domain.core.Produto;

import java.math.BigDecimal;
import java.util.UUID;

public record ProdutoResponseDTO(UUID id, String nome, CategoriaDTO categoria, BigDecimal preco, String descricao,
                                 String imagem) {

    public ProdutoResponseDTO(Produto produto) {
        this(produto.getId(), produto.getNome(), CategoriaDTO.valueOf(produto.getCategoria().name()), produto.getPreco(), produto.getDescricao(), produto.getImagem());
    }
}
