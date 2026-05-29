package br.com.fiap3espf.spacemonitorsystem.controller;

import br.com.fiap3espf.spacemonitorsystem.domain.sensor.*;
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
@RequestMapping("/sensores")
public class SensorController {
    @Autowired
    private SensorRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity<DadosDetalhamentoSensor> cadastrarSensor(
            @RequestBody @Valid DadosCadastroSensor dados,
            UriComponentsBuilder uriBuilder) {
        Sensor sensor = new Sensor(dados);
        Sensor saved = repository.save(sensor);
        URI uri = uriBuilder.buildAndExpand("/sensores/{id}").toUri();
        DadosDetalhamentoSensor dto = new DadosDetalhamentoSensor(saved);
        return ResponseEntity.created(uri).body(dto);
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemSensor>> listarSensores(
            @PageableDefault(size = 10, sort = "id") Pageable paginacao) {
        Page page = repository.findAllByAtivoTrue(paginacao).map(DadosListagemSensor::new);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DadosDetalhamentoSensor> detalharSensor(@PathVariable Long id) {
        Sensor sensor = repository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalhamentoSensor(sensor));
    }

    @PutMapping
    @Transactional
    public ResponseEntity<DadosDetalhamentoSensor> atualizarSensor(@RequestBody @Valid DadosAtualizacaoSensor dados) {
        Sensor sensor = repository.getReferenceById(dados.id());
        sensor.atualizarInformacoes(dados);
        Sensor saved = repository.save(sensor);
        return ResponseEntity.ok(new DadosDetalhamentoSensor(saved));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> excluirSensor(@PathVariable Long id) {
        Sensor sensor = repository.getReferenceById(id);
        sensor.excluir();
        repository.save(sensor);
        return ResponseEntity.noContent().build();
    }
}