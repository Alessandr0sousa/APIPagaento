package br.com.api.pagamentos.validations;

import br.com.api.pagamentos.pagamentos.Pagamento;

public interface ValidacaoPagamento {
    void validar(Pagamento pagamento);
}
