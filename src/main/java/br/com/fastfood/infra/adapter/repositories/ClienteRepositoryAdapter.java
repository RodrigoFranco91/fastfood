package br.com.fastfood.infra.adapter.repositories;


import br.com.fastfood.domain.core.Cliente;
import br.com.fastfood.domain.out.ClienteRepositoryPort;
import br.com.fastfood.infra.adapter.entities.ClienteEntity;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

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
}
