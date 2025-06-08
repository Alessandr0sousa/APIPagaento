package br.com.api.pagamentos.pagamentos;

import br.com.api.pagamentos.enumerates.PagamentoStatus;
import java.time.LocalDateTime;

public record ListarPagamentos(
        Long id,
        Integer codigoDebito,
        String cpfCnpj,
        Double valor,
        PagamentoStatus status,
        LocalDateTime dataPagamento,
        Boolean ativo
) {
    public ListarPagamentos(Pagamento pagamento){
        this(pagamento.getId(), pagamento.getCodigoDebito(), pagamento.getCpfCnpj(), pagamento.getValor(),
                pagamento.getStatus(), pagamento.getDataPagamento() ,pagamento.getAtivo());
    }
}
