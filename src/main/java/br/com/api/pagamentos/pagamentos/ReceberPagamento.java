package br.com.api.pagamentos.pagamentos;

import br.com.api.pagamentos.enumerates.MetodoPagamento;

public record ReceberPagamento(
        Integer codigoDebito,
        String cpfCnpj,
        MetodoPagamento metodoPagamento,
        String numeroCartao,
        Double valor
) {}

