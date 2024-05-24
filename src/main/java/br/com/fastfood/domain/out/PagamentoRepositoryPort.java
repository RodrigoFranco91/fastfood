package br.com.fastfood.domain.out;

import br.com.fastfood.domain.core.Pagamento;

public interface PagamentoRepositoryPort {

   Pagamento salvaPagamento(Pagamento pagamento);
}
