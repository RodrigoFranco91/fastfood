package br.com.fastfood.infra.adapter.entities;


import br.com.fastfood.domain.core.Categoria;
import br.com.fastfood.domain.core.Produto;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "produtos")
public class ProdutoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String nome;

    @Enumerated(EnumType.STRING)
    private Categoria categoria;
    private BigDecimal preco;
    private String descricao;
    private String imagem;

    public ProdutoEntity() {
    }

    public ProdutoEntity(Produto produto) {
        this.nome = produto.getNome();
        this.categoria = produto.getCategoria();
        this.preco = produto.getPreco();
        this.descricao = produto.getDescricao();
        this.imagem = produto.getImagem();
    }

    public Produto toDomain() {
        return new Produto(this.id, this.nome, this.categoria, this.preco, this.descricao, this.imagem);
    }
}
