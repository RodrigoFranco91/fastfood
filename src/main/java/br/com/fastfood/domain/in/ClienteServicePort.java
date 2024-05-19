package br.com.fastfood.domain.in;

import br.com.fastfood.application.adapter.rest.dto.request.ClienteDTO;
import br.com.fastfood.application.adapter.rest.dto.response.ClienteResponseDTO;

import java.util.Set;

public interface ClienteServicePort {
    ClienteResponseDTO cadastraCliente(ClienteDTO clienteDTO);

    ClienteResponseDTO buscaPorCpf(String cpf);

    Set<ClienteResponseDTO> buscaClientes();

    void deletaCliente(String cpf);

    ClienteResponseDTO atualizaCliente(ClienteDTO clienteDTO);
}
