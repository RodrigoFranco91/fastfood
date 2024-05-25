package br.com.fastfood.application.adapter.rest.controller;

import br.com.fastfood.application.adapter.rest.dto.response.PagamentoResponseDTO;
import br.com.fastfood.application.port.PagamentoControllerPort;
import br.com.fastfood.domain.in.PagamentoServicePort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.UUID;


@RestController
@RequestMapping("/pagamento")
public class PagamentoController implements PagamentoControllerPort {

    private PagamentoServicePort pagamentoService;

    public PagamentoController(PagamentoServicePort pagamentoService) {
        this.pagamentoService = pagamentoService;
    }

    @Override
    @PostMapping("/{pedidoId}")
    public ResponseEntity<PagamentoResponseDTO> pagamento(@PathVariable UUID pedidoId, UriComponentsBuilder uriComponentsBuilder) {

        var response = pagamentoService.pagamento(pedidoId);
        URI uri = uriComponentsBuilder.path("/pagamento/{id}").buildAndExpand(response.id()).toUri();
        return ResponseEntity.created(uri).body(response);
    }
}
