package br.com.fastfood.application.adapter.rest.controller;

import br.com.fastfood.application.adapter.rest.dto.response.PagamentoResponseDTO;
import br.com.fastfood.application.port.PagamentoControllerPort;
import br.com.fastfood.domain.in.PagamentoServicePort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RequestMapping
@RestController
public class PagamentoController implements PagamentoControllerPort {

    private PagamentoServicePort pagamentoService;

    public PagamentoController(PagamentoServicePort pagamentoService) {
        this.pagamentoService = pagamentoService;
    }

    @Override
    public ResponseEntity<PagamentoResponseDTO> pagamento(UUID pedidoId) {
        return null;
    }
}
