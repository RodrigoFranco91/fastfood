package br.com.fastfood.domain.out;

import br.com.fastfood.domain.core.Cliente;

public interface ClienteRepositoryPort {
    Cliente insereCliente(Cliente cliente);

    Cliente pesquisaPorCpf(String cpf);
}
