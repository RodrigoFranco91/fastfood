package br.com.fastfood.domain.in;

import br.com.fastfood.application.adapter.rest.dto.request.ClienteDTO;
import br.com.fastfood.application.adapter.rest.dto.response.ClienteResponseDTO;

public interface ClienteServicePort {
    ClienteResponseDTO cadastraCliente(ClienteDTO clienteDTO);

    ClienteResponseDTO buscaPorCpf(String cpf);
}
