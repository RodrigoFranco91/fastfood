package br.com.fastfood.application.port;

import br.com.fastfood.application.adapter.rest.dto.request.ClienteDTO;
import br.com.fastfood.application.adapter.rest.dto.response.ClienteResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;

public interface ClienteControllerPort {

    @Operation(summary = "Cadastro de Cliente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Cadastrando o Cliente:"),
    })
    ResponseEntity<ClienteResponseDTO> cadastrar(ClienteDTO clienteDTO, UriComponentsBuilder uriBuilder);

    @Operation(summary = "Busca de Cliente por CPF")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Cliente encontrado:"),
    })
    ResponseEntity<ClienteResponseDTO> listaPorCpf(String cpf);
}
