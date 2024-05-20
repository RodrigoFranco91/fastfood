package br.com.fastfood.application.adapter.service;

import br.com.fastfood.application.adapter.rest.dto.request.ClienteDTO;
import br.com.fastfood.application.adapter.rest.dto.response.ClienteResponseDTO;
import br.com.fastfood.domain.core.Cliente;
import br.com.fastfood.domain.in.ClienteServicePort;
import br.com.fastfood.domain.out.ClienteRepositoryPort;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ClienteServiceAdapter implements ClienteServicePort {

    private ClienteRepositoryPort clienteRepository;

    public ClienteServiceAdapter(ClienteRepositoryPort clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public ClienteResponseDTO cadastraCliente(ClienteDTO clienteDTO) {
        var cliente = new Cliente(clienteDTO);
        var clienteSalvo = clienteRepository.insereCliente(cliente);
        return new ClienteResponseDTO(clienteSalvo);
    }

    @Override
    public ClienteResponseDTO buscaPorCpf(String cpf) {
        var cliente = clienteRepository.pesquisaPorCpf(cpf);
        return new ClienteResponseDTO(cliente);
    }

    @Override
    public Set<ClienteResponseDTO> buscaClientes() {
        var clientes = clienteRepository.buscaClientes();
        return clientes.stream().map(ClienteResponseDTO::new).collect(Collectors.toSet());
    }

    @Override
    public void deletaCliente(String cpf) {
        clienteRepository.deletaCliente(cpf);
    }

    @Override
    public ClienteResponseDTO atualizaCliente(ClienteDTO clienteDTO) {
        var clienteAtualizado = clienteRepository.atualizaCliente(new Cliente(clienteDTO));
        return new ClienteResponseDTO(clienteAtualizado);
    }
}
