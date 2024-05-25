package br.com.fastfood.application.adapter.service;

import br.com.fastfood.application.adapter.rest.dto.response.PagamentoResponseDTO;
import br.com.fastfood.domain.core.Pagamento;
import br.com.fastfood.domain.core.StatusPedido;
import br.com.fastfood.domain.in.PagamentoServicePort;
import br.com.fastfood.domain.out.MercadoPagoPort;
import br.com.fastfood.domain.out.PagamentoRepositoryPort;
import br.com.fastfood.domain.out.PedidoRepositoryPort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

@Service
public class PagamentoServiceAdapter implements PagamentoServicePort {

    private PagamentoRepositoryPort pagamentoRepository;
    private MercadoPagoPort mercadoPago;

    private PedidoRepositoryPort pedidoRepository;

    public PagamentoServiceAdapter(PagamentoRepositoryPort pagamentoRepository, MercadoPagoPort mercadoPagoPort, PedidoRepositoryPort pedidoRepository) {
        this.pagamentoRepository = pagamentoRepository;
        this.mercadoPago = mercadoPagoPort;
        this.pedidoRepository = pedidoRepository;
    }

    @Override
    public PagamentoResponseDTO pagamento(UUID id) {

        var pedidoDomain = pedidoRepository.consultaPedidoPorId(id);
        if(!pedidoDomain.getStatusPedido().equals(StatusPedido.AGUARDANDO_PAGAMENTO)){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "O status do pedido " + id + " encontra-se em: " + pedidoDomain.getStatusPedido().name());
        }

        var responseMercadoPago = mercadoPago.efetivaPagamento(id);
        if (responseMercadoPago.getPago()) {

            pedidoDomain.setStatusPedido(StatusPedido.RECEBIDO);

            var pedidoStatusAtualizado = pedidoRepository.avancaStatusPedido(pedidoDomain);

            Pagamento pagamento = new Pagamento(Boolean.TRUE, pedidoStatusAtualizado.getTotal(), pedidoStatusAtualizado);
            var pagamentoDomainSalvo = pagamentoRepository.salvaPagamento(pagamento);

            return new PagamentoResponseDTO(pagamentoDomainSalvo);
        }
        throw new ResponseStatusException(HttpStatus.PAYMENT_REQUIRED, "Falha no pagamento do pedido: " + id);


    }
}
