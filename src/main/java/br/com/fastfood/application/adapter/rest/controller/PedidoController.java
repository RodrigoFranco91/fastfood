package br.com.fastfood.application.adapter.rest.controller;

import br.com.fastfood.application.adapter.rest.dto.request.PedidoDTO;
import br.com.fastfood.application.adapter.rest.dto.response.PedidoResponseDTO;
import br.com.fastfood.application.port.PedidoControllerPort;
import br.com.fastfood.domain.in.PedidoServicePort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@RequestMapping("/pedido")
@RestController
public class PedidoController implements PedidoControllerPort {

    private PedidoServicePort pedidoService;

    public PedidoController(PedidoServicePort pedidoService) {
        this.pedidoService = pedidoService;
    }

    @PostMapping
    public ResponseEntity<PedidoResponseDTO> pedido(@RequestBody PedidoDTO pedidoDTO, UriComponentsBuilder uriBuilder) {

        var response = pedidoService.cadastrarPedido(pedidoDTO);
        URI uri = uriBuilder.path("/pedido/{id}").buildAndExpand(response.id()).toUri();

        return ResponseEntity.created(uri).body(response);
    }

    @GetMapping
    public ResponseEntity<List<PedidoResponseDTO>> listagemDePedidos() {

        var response = pedidoService.listar();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PedidoResponseDTO> listagemDePedidoPeloId(@PathVariable UUID id) {

        var response = pedidoService.listarPorId(id);
        return ResponseEntity.ok(response);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> exclusaoDePedido(@PathVariable UUID id) {

        pedidoService.deletaPedido(id);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<PedidoResponseDTO> altuaizacaoDePedido(UUID id) {
        return null;
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<Set<PedidoResponseDTO>> listagemDePedidosPeloStatus(@PathVariable String status) {

        var response = pedidoService.listarPorStatus(status);
        return ResponseEntity.ok(response);
    }

    @PatchMapping("/status/{id}")
    public ResponseEntity<PedidoResponseDTO> avancaStatusDePedido(@PathVariable UUID id) {

        var response = pedidoService.avancaStatusPedido(id);
        return ResponseEntity.ok(response);
    }
}
