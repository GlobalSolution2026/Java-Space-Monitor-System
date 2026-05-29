package br.com.fiap3espf.spacemonitorsystem.controller;

import br.com.fiap3espf.spacemonitorsystem.domain.alerta.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/alertas")
public class AlertaController {
    @Autowired
    private AlertaRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity<DadosDetalhamentoAlerta> cadastrarAlerta(
            @RequestBody @Valid DadosCadastroAlerta dados,
            UriComponentsBuilder uriBuilder) {
        Alerta alerta = new Alerta(dados);
        Alerta saved = repository.save(alerta);
        URI uri = uriBuilder.buildAndExpand("/alertas/{id}").toUri();
        DadosDetalhamentoAlerta dto = new DadosDetalhamentoAlerta(saved);
        return ResponseEntity.created(uri).body(dto);
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemAlerta>> listarAlerta(
            @PageableDefault(size = 10, sort = "regiao") Pageable paginacao) {
        Page page = repository.findAllByAtivoTrue(paginacao).map(DadosListagemAlerta::new);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DadosDetalhamentoAlerta> detalharAlerta(@PathVariable Long id) {
        Alerta alerta = repository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalhamentoAlerta(alerta));
    }

    @PutMapping
    @Transactional
    public ResponseEntity<DadosDetalhamentoAlerta> atualizarAlerta(@RequestBody @Valid DadosAtualizacaoAlerta dados) {
        Alerta alerta = repository.getReferenceById(dados.id());
        alerta.atualizarInformacoes(dados);
        Alerta saved = repository.save(alerta);
        return ResponseEntity.ok(new DadosDetalhamentoAlerta(saved));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> excluirAlerta(@PathVariable Long id) {
        Alerta alerta = repository.getReferenceById(id);
        alerta.excluir();
        repository.save(alerta);
        return ResponseEntity.noContent().build();
    }
}
