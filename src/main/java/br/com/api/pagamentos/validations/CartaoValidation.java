package br.com.api.pagamentos.validations;

import br.com.api.pagamentos.pagamentos.Pagamento;

public class CartaoValidation implements ValidacaoPagamento{
    @Override
    public void validar(Pagamento pagamento) {
        if (pagamento.getNumeroCartao() == null || pagamento.getNumeroCartao().isBlank()) {
            throw new IllegalArgumentException("Número do cartão obrigatório para pagamentos com "
                    + pagamento.getMetodoPagamento().getDescricao() +".");
        }
    }
}
