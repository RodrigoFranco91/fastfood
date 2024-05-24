package br.com.fastfood.infra.adapter.repositories;

import br.com.fastfood.domain.core.Pagamento;
import br.com.fastfood.domain.out.PagamentoRepositoryPort;
import org.springframework.stereotype.Component;

@Component
public class PagamentoRepositoryAdapter implements PagamentoRepositoryPort {

    private SpringPagamentoRepository springPagamentoRepository;

    public PagamentoRepositoryAdapter(SpringPagamentoRepository springPagamentoRepository) {
        this.springPagamentoRepository = springPagamentoRepository;
    }

    @Override
    public Pagamento salvaPagamento(Pagamento pagamento) {
        return null;
    }
}
