package br.com.fastfood.application.adapter.rest.dto.request;



import br.com.fastfood.application.adapter.rest.dto.request.CategoriaDTO;
import br.com.fastfood.domain.core.Produto;

import java.math.BigDecimal;
import java.util.UUID;

public record ProdutoDTO(String nome, CategoriaDTO categoria, BigDecimal preco, String descricao, String imagem) {

    public ProdutoDTO(Produto produto) {
        this(produto.getNome(), CategoriaDTO.valueOf(produto.getCategoria().name()),produto.getPreco(), produto.getDescricao(), produto.getImagem());
    }
}
