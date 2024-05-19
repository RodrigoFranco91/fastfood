package br.com.fastfood.application.port;

import br.com.fastfood.application.adapter.rest.dto.request.PedidoDTO;
import br.com.fastfood.application.adapter.rest.dto.response.PedidoResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;

public interface PedidoControllerPort {


    @Operation(summary = "Cadastro de Pedido")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Pedido realizado:"),
    })
    ResponseEntity<PedidoResponseDTO> pedido(PedidoDTO pedidoDTO, UriComponentsBuilder uriBuilder);
}
