package br.com.fastfood.domain.core;


import br.com.fastfood.application.adapter.rest.dto.request.ProdutoDTO;

import java.math.BigDecimal;
import java.util.UUID;

public class Produto {

    private UUID id;
    private String nome;
    private Categoria categoria;
    private BigDecimal preco;
    private String descricao;
    private String imagem;

    public Produto(UUID id, String nome, Categoria categoria, BigDecimal preco, String descricao, String imagem) {
        this.id = id;
        this.nome = nome;
        this.categoria = categoria;
        this.preco = preco;
        this.descricao = descricao;
        this.imagem = imagem;
    }

    public Produto(ProdutoDTO produtoDTO) {

        this.nome = produtoDTO.nome();
        this.categoria = Categoria.valueOf(produtoDTO.categoria().name());
        this.preco = produtoDTO.preco();
        this.descricao = produtoDTO.descricao();
        this.imagem = produtoDTO.imagem();
    }

    public Produto(UUID id, ProdutoDTO produtoDTO) {
        this.id = id;
        this.nome = produtoDTO.nome();
        this.categoria = Categoria.valueOf(produtoDTO.categoria().name());
        this.preco = produtoDTO.preco();
        this.descricao = produtoDTO.descricao();
        this.imagem = produtoDTO.imagem();
    }

    public UUID getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getImagem() {
        return imagem;
    }
}
