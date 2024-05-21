package br.com.fastfood.application.adapter.service;

import br.com.fastfood.application.adapter.rest.dto.request.PedidoDTO;
import br.com.fastfood.domain.core.ItemPedido;
import br.com.fastfood.domain.core.Pedido;
import br.com.fastfood.domain.in.PedidoServicePort;
import br.com.fastfood.domain.out.ClienteRepositoryPort;
import br.com.fastfood.domain.out.PedidoRepositoryPort;
import br.com.fastfood.domain.out.ProdutoRepositoryPort;
import org.springframework.stereotype.Service;

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
    public void cadastrarPedido(PedidoDTO pedidoDTO) {

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
        pedidoRepository.inserePedido(pedidoDomain);
    }
}
