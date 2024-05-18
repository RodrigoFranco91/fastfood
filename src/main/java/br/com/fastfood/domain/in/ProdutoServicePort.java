package br.com.fastfood.domain.in;


import br.com.fastfood.application.adapter.rest.dto.request.ProdutoDTO;
import br.com.fastfood.application.adapter.rest.dto.response.ProdutoResponseDTO;

import java.util.Set;
import java.util.UUID;

public interface ProdutoServicePort {


     ProdutoResponseDTO cadastraProduto(ProdutoDTO request);

     Set<ProdutoResponseDTO> listarTodosProdutos();

     ProdutoResponseDTO listarProdutoPorId(UUID id);

     void deletarProduto(UUID id);

     ProdutoResponseDTO atualizarProduto(UUID id, ProdutoDTO produtoDTO);
}
