package br.com.fastfood.application.adapter.rest.controller;

import br.com.fastfood.application.adapter.rest.dto.request.ClienteDTO;
import br.com.fastfood.application.adapter.rest.dto.response.ClienteResponseDTO;
import br.com.fastfood.application.port.ClienteControllerPort;
import br.com.fastfood.domain.in.ClienteServicePort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Set;

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

    @GetMapping
    public ResponseEntity<Set<ClienteResponseDTO>> listar() {
        var response = clienteService.buscaClientes();
        return ResponseEntity.ok(response);

    }

    @DeleteMapping("/{cpf}")
    public ResponseEntity<Void> deletar(@PathVariable String cpf){
        clienteService.deletaCliente(cpf);
        return ResponseEntity.noContent().build();
    }

    @PutMapping
    public ResponseEntity<ClienteResponseDTO> atualizar(@RequestBody ClienteDTO clienteDTO) {
        var response = clienteService.atualizaCliente(clienteDTO);
        return ResponseEntity.ok(response);
    }
}
