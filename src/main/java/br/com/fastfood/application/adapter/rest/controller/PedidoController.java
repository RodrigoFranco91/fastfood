package br.com.fastfood.application.adapter.rest.controller;

import br.com.fastfood.application.adapter.rest.dto.request.PedidoDTO;
import br.com.fastfood.application.adapter.rest.dto.response.PedidoResponseDTO;
import br.com.fastfood.application.port.PedidoControllerPort;
import br.com.fastfood.domain.in.PedidoServicePort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

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
}
