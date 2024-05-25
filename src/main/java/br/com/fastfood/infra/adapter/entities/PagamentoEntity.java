package br.com.fastfood.infra.adapter.entities;

import br.com.fastfood.domain.core.Pagamento;
import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.math.BigDecimal;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.UUID;

@Entity
@Table(name = "pagamentos")
public class PagamentoEntity {

    public PagamentoEntity() {
    }

    public PagamentoEntity(Pagamento pagamento) {

        this.dataHora = pagamento.getDataHora();
        this.pago = pagamento.getPago();
        this.valorCobrado = pagamento.getValorCobrado();
        this.pedido = new PedidoEntity(pagamento.getPedido(), pagamento.getPedido().getId());
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JdbcTypeCode(SqlTypes.CHAR)
    @Column(columnDefinition = "varchar(36)")
    private UUID id;
    private ZonedDateTime dataHora = ZonedDateTime.now(ZoneId.of("America/Sao_Paulo"));


    private Boolean pago = Boolean.FALSE;

    private BigDecimal valorCobrado;

    @ManyToOne
    private PedidoEntity pedido;

    public UUID getId() {
        return id;
    }

    public Pagamento toDomain(){
        return new Pagamento(this.pago,this.valorCobrado, pedido.toDomain());
    }

}
