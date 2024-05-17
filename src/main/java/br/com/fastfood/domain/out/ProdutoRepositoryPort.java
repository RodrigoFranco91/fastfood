package br.com.fastfood.domain.out;


import br.com.fastfood.domain.core.Produto;

import java.util.Set;

public interface ProdutoRepositoryPort {

     Produto insertProduto(Produto produto);

    Set<Produto> pegarProdutos();
}
