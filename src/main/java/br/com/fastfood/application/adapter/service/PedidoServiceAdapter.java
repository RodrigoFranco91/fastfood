package br.com.fastfood.application.adapter.service;

import br.com.fastfood.application.adapter.rest.dto.request.PedidoDTO;
import br.com.fastfood.application.adapter.rest.dto.response.PedidoResponseDTO;
import br.com.fastfood.domain.core.ItemPedido;
import br.com.fastfood.domain.core.Pedido;
import br.com.fastfood.domain.core.StatusPedido;
import br.com.fastfood.domain.in.PedidoServicePort;
import br.com.fastfood.domain.out.ClienteRepositoryPort;
import br.com.fastfood.domain.out.PedidoRepositoryPort;
import br.com.fastfood.domain.out.ProdutoRepositoryPort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class PedidoServiceAdapter implements PedidoServicePort {

    private PedidoRepositoryPort pedidoRepository;
    private ClienteRepositoryPort clienteRepository;
    private ProdutoRepositoryPort produtoRepository;

    public PedidoServiceAdapter(PedidoRepositoryPort pedidoRepository, ClienteRepositoryPort clienteRepository, ProdutoRepositoryPort produtoRepository) {
        this.pedidoRepository = pedidoRepository;
        this.clienteRepository = clienteRepository;
        this.produtoRepository = produtoRepository;
    }

    @Override
    public PedidoResponseDTO cadastrarPedido(PedidoDTO pedidoDTO) {

        var clienteDomain = clienteRepository.pesquisaPorCpf(pedidoDTO.cpfCliente());
        var pedidoDomain = new Pedido();
        pedidoDTO.itens().forEach(itensPedidoDTO -> {
            var produtoDomain = produtoRepository.pegarProduto(itensPedidoDTO.produtoId());
            ItemPedido itemPedidoDomain = new ItemPedido(produtoDomain, itensPedidoDTO.quantidade(), produtoDomain.getPreco());
            itemPedidoDomain.setPedido(pedidoDomain);
            pedidoDomain.getItensPedido().add(itemPedidoDomain);
        });

        pedidoDomain.setCliente(clienteDomain);
        pedidoDomain.calculaTotal();
        var pedidoDomainSalvo = pedidoRepository.inserePedido(pedidoDomain);
        return new PedidoResponseDTO(pedidoDomainSalvo);
    }

    @Override
    public List<PedidoResponseDTO> listar() {

        var pedidoDomainList = pedidoRepository.consultaPedidos();
        return pedidoDomainList.stream().map(PedidoResponseDTO::new).collect(Collectors.toList());
    }

    @Override
    public PedidoResponseDTO listarPorId(UUID id) {

        var pedidoDoamin = pedidoRepository.consultaPedidoPorId(id);
        return new PedidoResponseDTO(pedidoDoamin);
    }

    @Override
    public void deletaPedido(UUID id) {

        pedidoRepository.deletaPedido(id);
    }

    @Override
    public Set<PedidoResponseDTO> listarPorStatus(String status) {
        status = status.trim().toUpperCase();
        try {
            StatusPedido statusPedido = StatusPedido.valueOf(status);
            var pedidosDoaminList = pedidoRepository.consultaPedidoPorStatus(statusPedido);
            return pedidosDoaminList.stream().map(PedidoResponseDTO::new).collect(Collectors.toSet());
        } catch (IllegalArgumentException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "O Status " + status + " não é válido!");
        }

    }

    @Override
    public PedidoResponseDTO avancaStatusPedido(UUID id) {
        var pedidoDomain = pedidoRepository.consultaPedidoPorId(id);
        if(pedidoDomain.getStatusPedido().equals(StatusPedido.AGUARDANDO_PAGAMENTO) || pedidoDomain.getStatusPedido().equals(StatusPedido.FINALIZADO)){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "O Status " + pedidoDomain.getStatusPedido().name() + " não pode ser avançado!");
        }

        pedidoDomain.avancaStatus();

        var pedidoDoaminAtualizado = pedidoRepository.avancaStatusPedido(pedidoDomain);
        return new PedidoResponseDTO(pedidoDoaminAtualizado);
    }
}
