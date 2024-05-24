package br.com.fastfood.application.port;

import br.com.fastfood.application.adapter.rest.dto.request.PedidoDTO;
import br.com.fastfood.application.adapter.rest.dto.response.PedidoResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Set;
import java.util.UUID;

public interface PedidoControllerPort {


    @Operation(summary = "Cadastro de Pedido")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Pedido realizado:"),
    })
    ResponseEntity<PedidoResponseDTO> pedido(PedidoDTO pedidoDTO, UriComponentsBuilder uriBuilder);





    @Operation(summary = "Listagem de todos os Pedidos")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Pedidos Existentes:"),
    })
    ResponseEntity<List<PedidoResponseDTO>> listagemDePedidos();

    @Operation(summary = "Listagem de Pedido pelo ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Pedido:"),
    })
    ResponseEntity<PedidoResponseDTO> listagemDePedidoPeloId(UUID id);

    @Operation(summary = "Exclusão de um Pedido")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Pedido excluído."),
    })
    ResponseEntity<Void> exclusaoDePedido(UUID id);

    @Operation(summary = "Atualização de um Pedido")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Pedido excluído."),
    })
    ResponseEntity<PedidoResponseDTO> altuaizacaoDePedido(UUID id);

    @Operation(summary = "Listagem de Pedidos pelo seu Status/Estágio")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Pedidos existentes no Status que você escolheu:"),
    })
    ResponseEntity<Set<PedidoResponseDTO>> listagemDePedidosPeloStatus(String status);

    @Operation(summary = "Avança os Status/Estágio de um Pedido")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Pedidos existentes no Status que você escolheu:"),
    })
    ResponseEntity<PedidoResponseDTO> avancaStatusDePedido(UUID id);
}
