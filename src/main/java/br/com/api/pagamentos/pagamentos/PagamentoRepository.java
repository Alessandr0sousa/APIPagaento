package br.com.api.pagamentos.pagamentos;

import aj.org.objectweb.asm.commons.Remapper;
import jdk.jfr.Registered;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

@Registered
public interface PagamentoRepository extends JpaRepository<Pagamento, Long> {

    Page<Pagamento> getReferenceByAtivoTrue(Pageable pageable);
}
