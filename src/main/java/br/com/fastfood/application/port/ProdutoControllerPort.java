package br.com.fastfood.application.port;

import br.com.fastfood.application.adapter.rest.dto.request.ProdutoDTO;
import br.com.fastfood.application.adapter.rest.dto.response.ProdutoResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Set;

public interface ProdutoControllerPort {

    @Operation(summary = "Cadastro de Produto")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Produto Criado:"),
    })
    public ResponseEntity<ProdutoResponseDTO> cadastrar(ProdutoDTO produtoDTO, HttpServletRequest request, UriComponentsBuilder uriBuilder);

    @Operation(summary = "Listagem dos Produtos")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Produtos Existentes:"),
    })
    public ResponseEntity<Set<ProdutoResponseDTO>> listarProdutos();
}