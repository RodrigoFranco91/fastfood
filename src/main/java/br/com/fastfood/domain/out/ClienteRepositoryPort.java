package br.com.fastfood.domain.out;

import br.com.fastfood.domain.core.Cliente;

import java.util.Set;

public interface ClienteRepositoryPort {
    Cliente insereCliente(Cliente cliente);

    Cliente pesquisaPorCpf(String cpf);

    Set<Cliente> buscaClientes();

    void deletaCliente(String cpf);

    Cliente atualizaCliente(Cliente cliente);
}
