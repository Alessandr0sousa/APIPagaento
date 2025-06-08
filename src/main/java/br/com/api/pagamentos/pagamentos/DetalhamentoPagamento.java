package br.com.api.pagamentos.pagamentos;

import br.com.api.pagamentos.enumerates.PagamentoStatus;

import java.time.LocalDateTime;

public record DetalhamentoPagamento(
        Long id,
        Integer codigoDebito,
        String cpfCnpj,
        Double valor,
        PagamentoStatus status,
        LocalDateTime dataPagamento,
        Boolean ativo
) {
    public DetalhamentoPagamento(Pagamento pagamento) {
        this(pagamento.getId(), pagamento.getCodigoDebito(), pagamento.getCpfCnpj(), pagamento.getValor(),
                pagamento.getStatus(), pagamento.getDataPagamento(), pagamento.getAtivo());
    }
}
