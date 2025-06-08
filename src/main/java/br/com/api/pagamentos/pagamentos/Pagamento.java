package br.com.api.pagamentos.pagamentos;

import br.com.api.pagamentos.enumerates.MetodoPagamento;
import br.com.api.pagamentos.enumerates.PagamentoStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "pagamentos")
@Data
@NoArgsConstructor
public class Pagamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull(message = "O código do debito não pode ser nulo")
    private Integer codigoDebito;
    @Column(nullable = false, length = 14)
    private String cpfCnpj;
    @Enumerated(EnumType.STRING)
    private MetodoPagamento metodoPagamento;
    private String numeroCartao;
    @NotNull
    private Double valor;
    @Enumerated(EnumType.STRING)
    private PagamentoStatus status = PagamentoStatus.PENDENTE_PROCESSAMENTO;
    private LocalDateTime dataPagamento =  LocalDateTime.now();
    private Boolean ativo = true;

    public Pagamento(ReceberPagamento receberPagamento) {
        this.codigoDebito = receberPagamento.codigoDebito();
        this.cpfCnpj = receberPagamento.cpfCnpj();
        this.metodoPagamento = receberPagamento.metodoPagamento();
        this.numeroCartao = receberPagamento.numeroCartao();
        this.valor = receberPagamento.valor();
    }

}


