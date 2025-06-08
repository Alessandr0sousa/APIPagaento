package br.com.api.pagamentos.pagamentos;

import br.com.api.pagamentos.enumerates.MetodoPagamento;
import br.com.api.pagamentos.enumerates.PagamentoStatus;
import br.com.api.pagamentos.validations.CartaoValidation;
import br.com.api.pagamentos.validations.StatusValidation;
import br.com.api.pagamentos.validations.ValidacaoPagamento;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class PagamentoService {
    @Autowired
    private PagamentoRepository repository;

    public Page<ListarPagamentos> ListarPagamentos(Pageable pageable) {
        return repository.getReferenceByAtivoTrue(pageable).map(ListarPagamentos::new);
    }

    public Pagamento receberPagamento(ReceberPagamento pagamento) {
        var dadosPagamento = new Pagamento(pagamento);
        validarMetodoPagamento(dadosPagamento);
        return repository.save(dadosPagamento);
    }

    public Pagamento atualizarStatus(Long id, AtualizarStatus atualizarStatus) {
        Pagamento pagamento = buscarPagamento(id);

        StatusValidation.validarNovoStatus(pagamento, atualizarStatus);
        pagamento.setStatus(atualizarStatus.status());
        return repository.save(pagamento);
    }

    public Pagamento deletarPagamento(Long id) {
        Pagamento pagamento = buscarPagamento(id);

        if (pagamento.getStatus().equals(PagamentoStatus.PENDENTE_PROCESSAMENTO)) {
            pagamento.setAtivo(false);
            return repository.save(pagamento);
        } else {
            throw new IllegalStateException("Apenas pagamentos pendentes podem ser inativados.");
        }
    }

    private final Map<MetodoPagamento, ValidacaoPagamento> estrategias = Map.of(
            MetodoPagamento.CARTAO_CREDITO, new CartaoValidation(),
            MetodoPagamento.CARTAO_DEBITO, new CartaoValidation()
    );

    private void validarMetodoPagamento(Pagamento pagamento) {
        ValidacaoPagamento estrategia = estrategias.get(pagamento.getMetodoPagamento());
        if (estrategia != null) {
            estrategia.validar(pagamento);
        }
    }

    private Pagamento buscarPagamento(Long id) {
        return repository.findById(id).orElseThrow(() ->
                new EntityNotFoundException("Pagamento não encontrado"));
    }
}