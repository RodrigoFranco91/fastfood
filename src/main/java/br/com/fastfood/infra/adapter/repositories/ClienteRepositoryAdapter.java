package br.com.fastfood.infra.adapter.repositories;


import br.com.fastfood.domain.core.Cliente;
import br.com.fastfood.domain.out.ClienteRepositoryPort;
import br.com.fastfood.infra.adapter.entities.ClienteEntity;
import jakarta.transaction.Transactional;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class ClienteRepositoryAdapter implements ClienteRepositoryPort {


    public ClienteRepositoryAdapter(SpringClienteRepository springClienteRepository) {
        this.springClienteRepository = springClienteRepository;
    }

    private SpringClienteRepository springClienteRepository;

    @Override
    public Cliente insereCliente(Cliente cliente) {
        var clienteEntity = new ClienteEntity(cliente);
        var clienteSalvo = springClienteRepository.save(clienteEntity);
        return clienteSalvo.toDomain();
    }

    @Override
    public Cliente pesquisaPorCpf(String cpf) {
        var clienteEntity = springClienteRepository.findByCpf(cpf).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Não existe Cliente com o CPF " + cpf));
        return clienteEntity.toDomain();
    }

    @Override
    public Set<Cliente> buscaClientes() {
        var clientes = springClienteRepository.findAll();
        return clientes.stream().map(ClienteEntity::toDomain).collect(Collectors.toSet());
    }

    @Override
    @Transactional
    public void deletaCliente(String cpf) {
        springClienteRepository.findByCpf(cpf).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Não existe Cliente com o CPF " + cpf));
        springClienteRepository.deleteByCpf(cpf);
    }

    @Override
    public Cliente atualizaCliente(Cliente cliente) {
        var clienteEntity = springClienteRepository.findByCpf(cliente.getCpf()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Não existe Cliente com o CPF " + cliente.getCpf()));
        clienteEntity.setEmail(cliente.getEmail());
        clienteEntity.setSenha(cliente.getSenha());
        clienteEntity.setNome(cliente.getNome());
        return springClienteRepository.save(clienteEntity).toDomain();
    }


}
