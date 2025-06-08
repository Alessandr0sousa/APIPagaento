package br.com.api.pagamentos.validations;

import br.com.api.pagamentos.enumerates.PagamentoStatus;
import br.com.api.pagamentos.pagamentos.AtualizarStatus;
import br.com.api.pagamentos.pagamentos.Pagamento;

public class StatusValidation {
    public static void validarNovoStatus(Pagamento pagamento, AtualizarStatus novoStatus) {
        if (pagamento.getStatus().equals(PagamentoStatus.PROCESSADO_COM_SUCESSO)) {
            throw new IllegalArgumentException("Pagamento já " + PagamentoStatus.PROCESSADO_COM_SUCESSO.getDescricao() +
                    " e não pode ser alterado.");
        }
        if (pagamento.getStatus().equals(PagamentoStatus.PROCESSADO_COM_FALHA) && novoStatus.status() != PagamentoStatus.PENDENTE_PROCESSAMENTO) {
            throw new IllegalArgumentException(PagamentoStatus.PROCESSADO_COM_FALHA.getDescricao() +
                    " só pode ser alterado para o status " + PagamentoStatus.PENDENTE_PROCESSAMENTO.getDescricao() + ".");
        }
    }
}
