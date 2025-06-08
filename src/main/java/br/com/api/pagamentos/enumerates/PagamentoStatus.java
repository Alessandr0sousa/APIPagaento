package br.com.api.pagamentos.enumerates;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum PagamentoStatus {
    PENDENTE_PROCESSAMENTO(1, "Pendente de Processamento"),
    PROCESSADO_COM_SUCESSO(2, "Processado com Sucesso"),
    PROCESSADO_COM_FALHA(3, "Processado com Falha");

    private final int codigo;
    private final String descricao;

    public int getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public static PagamentoStatus fromCodigo(int codigo) {
        for (PagamentoStatus status : values()) {
            if (status.getCodigo() == codigo) {
                return status;
            }
        }
        throw new IllegalArgumentException("Código de status inválido: " + codigo);
    }
}
