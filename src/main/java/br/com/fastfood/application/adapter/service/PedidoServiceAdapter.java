package br.com.fastfood.application.adapter.service;

import br.com.fastfood.application.adapter.rest.dto.request.PedidoDTO;
import br.com.fastfood.application.adapter.rest.dto.response.ClienteResponseDTO;
import br.com.fastfood.application.adapter.rest.dto.response.ItemPedidoResponseDto;
import br.com.fastfood.application.adapter.rest.dto.response.PedidoResponseDTO;
import br.com.fastfood.domain.core.ItemPedido;
import br.com.fastfood.domain.core.Pedido;
import br.com.fastfood.domain.in.PedidoServicePort;
import br.com.fastfood.domain.out.ClienteRepositoryPort;
import br.com.fastfood.domain.out.PedidoRepositoryPort;
import br.com.fastfood.domain.out.ProdutoRepositoryPort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

        List<ItemPedido> itemPedidoList = new ArrayList<>();
        var cliente = clienteRepository.pesquisaPorCpf(pedidoDTO.cpfCliente());

        pedidoDTO.itens().forEach(item -> {
            var produto = produtoRepository.pegarProduto(item.produtoId());
            itemPedidoList.add(new ItemPedido(produto, item.quantidade(), produto.getPreco()));
        });

        Pedido pedido = new Pedido(cliente, itemPedidoList);
        var pedidoCriado = pedidoRepository.inserePedido(pedido);

        var clienteResponseDTO = new ClienteResponseDTO(pedidoCriado.getCliente().getId(), pedidoCriado.getCliente().getCpf(), pedidoCriado.getCliente().getNome(), pedidoCriado.getCliente().getEmail());
        List<ItemPedidoResponseDto> itensPedidoResponseDto = new ArrayList<>();
        pedidoCriado.getItensPedido().forEach(itemPedido -> {
            ItemPedidoResponseDto itemPedidoResponseDto = new ItemPedidoResponseDto(itemPedido.getProduto().getNome(), itemPedido.getQuantidadeDoItem(), itemPedido.getPrecoAtualDoIem());
            itensPedidoResponseDto.add(itemPedidoResponseDto);
        });

        return new PedidoResponseDTO(pedidoCriado, clienteResponseDTO, itensPedidoResponseDto);
    }
}
