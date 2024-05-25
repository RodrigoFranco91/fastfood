package br.com.fastfood.application.port;

import br.com.fastfood.application.adapter.rest.dto.response.PagamentoResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.UUID;

public interface PagamentoControllerPort {

    @Operation(summary = "Realização do Pagamento de um Pedido (Fake Checkout)")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Pagamento Realizado:"),
    })
    ResponseEntity<PagamentoResponseDTO> pagamento(UUID pedidoId, UriComponentsBuilder uriComponentsBuilder);
}
