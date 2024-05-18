package br.com.fastfood.domain.out;


import br.com.fastfood.domain.core.Categoria;
import br.com.fastfood.domain.core.Produto;

import java.util.Set;
import java.util.UUID;

public interface ProdutoRepositoryPort {

     Produto insertProduto(Produto produto);

    Set<Produto> pegarProdutos();

    Produto pegarProduto(UUID id);

    void removerProduto(UUID id);

    Produto atualizarProduto(Produto produto);

    Set<Produto> pegarProdutosPelaCategoria(Categoria categoria);
}
