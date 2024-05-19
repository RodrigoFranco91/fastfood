package br.com.fastfood.infra.adapter.entities;

import br.com.fastfood.domain.core.StatusPedido;
import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.math.BigDecimal;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "pedidos")
public class PedidoEntity {

    public PedidoEntity() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JdbcTypeCode(SqlTypes.CHAR)
    @Column(columnDefinition = "varchar(36)")
    private UUID id;
    private ClienteEntity cliente;
    private BigDecimal total;
    private final ZonedDateTime data = ZonedDateTime.now(ZoneId.of("America/Sao_Paulo"));
    private StatusPedido statusPedido;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pedido")
    private List<ItemPedidoEntity> itensPedido;


    public void calculaTotal() {

        itensPedido.forEach(itemPedido -> {
            total = total.add(itemPedido.calculaTotal());
        });
    }
}
