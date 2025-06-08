package br.com.api.pagamentos.enumerates;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum MetodoPagamento {
    BOLETO(1, "Boleto"),
    PIX(2, "Pix"),
    CARTAO_CREDITO(3, "Cartão de Crédito"),
    CARTAO_DEBITO(4, "Cartão de Débito");

    private final int codigo;
    private final String descricao;

    public int getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public static MetodoPagamento fromCodigo(int codigo) {
        for (MetodoPagamento metodo : values()) {
            if (metodo.getCodigo() == codigo) {
                return metodo;
            }
        }
        throw new IllegalArgumentException("Código de método de pagamento inválido: " + codigo);
    }
}
