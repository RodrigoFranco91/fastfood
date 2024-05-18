package br.com.fastfood.application.adapter.service;

import br.com.fastfood.application.adapter.rest.dto.request.ClienteDTO;
import br.com.fastfood.application.adapter.rest.dto.response.ClienteResponseDTO;
import br.com.fastfood.domain.core.Cliente;
import br.com.fastfood.domain.in.ClienteServicePort;
import br.com.fastfood.infra.adapter.repositories.ClienteRepositoryAdapter;
import org.springframework.stereotype.Service;

@Service
public class ClienteServiceAdapter implements ClienteServicePort {

    private ClienteRepositoryAdapter clienteRepository;

    public ClienteServiceAdapter(ClienteRepositoryAdapter clienteRepository) {
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
}
