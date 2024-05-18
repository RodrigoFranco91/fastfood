package br.com.fastfood.infra.adapter.entities;

import br.com.fastfood.domain.core.Cliente;
import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.UUID;
@Entity
@Table(name = "clientes")
public class ClienteEntity {

    public ClienteEntity() {
    }

    public ClienteEntity(Cliente cliente) {
        this.cpf = cliente.getCpf();
        this.nome = cliente.getNome();
        this.email = cliente.getEmail();
        this.senha = cliente.getSenha();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JdbcTypeCode(SqlTypes.CHAR)
    @Column(columnDefinition = "varchar(36)")
    private UUID id;
    private String cpf;
    private String nome;
    private String email;
    private String senha;


    public Cliente toDomain() {
        return new Cliente(this.id, this.cpf, this.nome, this.email, this.senha);
    }
}
