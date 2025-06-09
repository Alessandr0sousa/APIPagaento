package br.com.api.pagamentos.pagamentos;

import br.com.api.pagamentos.enumerates.PagamentoStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/pagamentos")
public class PagamentoController {
    @Autowired
    private PagamentoService service;

    @GetMapping
    public ResponseEntity<Page<ListarPagamentos>> listarPagamentos(
            @RequestParam(required = false) Integer codigoDebito,
            @RequestParam(required = false) String cpfCnpj,
            @RequestParam(required = false) PagamentoStatus status,
            Pageable pageable) {
        var listPage = service.ListarPagamentos(codigoDebito, cpfCnpj, status, pageable);
        return ResponseEntity.ok(listPage);
    }

    @PostMapping
    public ResponseEntity receberPagamento(@RequestBody ReceberPagamento pagamento, UriComponentsBuilder uriBuilder) {
        var dadosPagamento = service.receberPagamento(pagamento);
        var uri = uriBuilder.path("/pagamentos/{id}").buildAndExpand(dadosPagamento.getId()).toUri();
        return ResponseEntity.created(uri).body(new DetalhamentoPagamento(dadosPagamento));
    }

    @PutMapping("/{id}/status")
    public ResponseEntity atualizarStatusPagamento(@PathVariable Long id, @RequestBody AtualizarStatus atualizarStatus) {
        return ResponseEntity.ok(service.atualizarStatus(id, atualizarStatus));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity excluirLogicamente(@PathVariable Long id) {
        service.deletarPagamento(id);
        return ResponseEntity.ok().build();
    }
}
