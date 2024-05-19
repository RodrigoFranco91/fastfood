package br.com.fastfood.infra.adapter.repositories;

import br.com.fastfood.infra.adapter.entities.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface SpringClienteRepository extends JpaRepository<ClienteEntity, UUID> {

    Optional<ClienteEntity> findByCpf(String cpf);

    void deleteByCpf(String cpf);
}
