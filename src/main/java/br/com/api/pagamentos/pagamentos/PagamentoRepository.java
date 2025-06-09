package br.com.api.pagamentos.pagamentos;

import br.com.api.pagamentos.enumerates.PagamentoStatus;
import jdk.jfr.Registered;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

@Registered
public interface PagamentoRepository extends JpaRepository<Pagamento, Long> {

    Pagamento findByCodigoDebito(Integer codigoDebito);
    Page<Pagamento> getReferenceByStatus(PagamentoStatus status, Pageable pageable);
    Page<Pagamento> getReferenceByCpfCnpj(String cpfCnpj, Pageable pageable);
    Page<Pagamento> getReferenceByCodigoDebito(Integer codigoDebito, Pageable pageable);
}
