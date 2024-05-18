package br.com.fastfood.application.adapter.rest.controller;

import br.com.fastfood.application.adapter.rest.dto.request.ClienteDTO;
import br.com.fastfood.application.adapter.rest.dto.response.ClienteResponseDTO;
import br.com.fastfood.application.port.ClienteControllerPort;
import br.com.fastfood.domain.in.ClienteServicePort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RequestMapping("/cliente")
@RestController
public class ClienteController implements ClienteControllerPort {

    private ClienteServicePort clienteService;

    public ClienteController(ClienteServicePort clienteService) {
        this.clienteService = clienteService;
    }

    @PostMapping
    public ResponseEntity<ClienteResponseDTO> cadastrar(@RequestBody ClienteDTO clienteDTO, UriComponentsBuilder uriBuilder) {

        var response = clienteService.cadastraCliente(clienteDTO);
        URI uri = uriBuilder.path("/cliente/{id}").buildAndExpand(response.id()).toUri();
        return ResponseEntity.created(uri).body(response);
    }

    @GetMapping("/{cpf}")
    public ResponseEntity<ClienteResponseDTO> listaPorCpf(@PathVariable String cpf) {
        var response = clienteService.buscaPorCpf(cpf);
        return ResponseEntity.ok(response);
    }
}
