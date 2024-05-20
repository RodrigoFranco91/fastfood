package br.com.fastfood.application.port;

import br.com.fastfood.application.adapter.rest.dto.request.ProdutoDTO;
import br.com.fastfood.application.adapter.rest.dto.response.ProdutoResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Set;
import java.util.UUID;

public interface ProdutoControllerPort {

    @Operation(summary = "Cadastro de Produto")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Produto Criado:"),
    })
    ResponseEntity<ProdutoResponseDTO> cadastrar(ProdutoDTO produtoDTO, UriComponentsBuilder uriBuilder);

    @Operation(summary = "Listagem dos Produtos")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Produtos Existentes:"),
    })
    ResponseEntity<Set<ProdutoResponseDTO>> listarProdutos();

    @Operation(summary = "Listagem de um Produto pelo seu ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Produto Existente:"),
    })
    ResponseEntity<ProdutoResponseDTO> listarProduto(UUID id);

    @Operation(summary = "Exclusão de Produto")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Produto foi deletado."),
    })
    ResponseEntity<Void> deletarProduto(UUID id);

    @Operation(summary = "Atualização de Produto")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Produto foi Atualizado:"),
    })
    ResponseEntity<ProdutoResponseDTO> atualizarProduto(UUID id, ProdutoDTO produtoDTO);

    @Operation(summary = "Listagem de Produtos através de Categoria:")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Produtos Existentes na categoria selecionada:"),
    })
    ResponseEntity<Set<ProdutoResponseDTO>> listagemDeProdutosPelaCategoria(String categoria);
}