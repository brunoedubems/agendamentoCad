package br.com.brunoedubems.agendamento.controller;

import br.com.brunoedubems.agendamento.dto.agendamento.AgendamentoRequest;
import br.com.brunoedubems.agendamento.dto.agendamento.AgendamentoResponse;
import br.com.brunoedubems.agendamento.dto.agendamento.AgendamentoUpdate;
import br.com.brunoedubems.agendamento.service.AgendamentoService;
import jakarta.validation.Valid;
import org.springframework.cglib.core.Local;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/agendamentos")
public class AgendamentoController {

    private final AgendamentoService agendamentoService;

    public AgendamentoController(AgendamentoService agendamentoService) {
        this.agendamentoService = agendamentoService;
    }

    @PostMapping
    public ResponseEntity<AgendamentoResponse> criar(@Valid @RequestBody AgendamentoRequest agendamentoRequest) {
        AgendamentoResponse agendamentoSalvo = agendamentoService.save(agendamentoRequest);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(agendamentoSalvo.id()).toUri();
        return ResponseEntity.created(uri).body(agendamentoSalvo);
    }

    @GetMapping()
    public ResponseEntity<List<AgendamentoResponse>> findAll() {
        return ResponseEntity.ok(agendamentoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AgendamentoResponse> buscar(@PathVariable Long id) {
        return ResponseEntity.ok(agendamentoService.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AgendamentoResponse> update(@PathVariable Long id,
                                                      @Valid @RequestBody AgendamentoUpdate agendamentoUpdate) {
        return ResponseEntity.ok(agendamentoService.update(id, agendamentoUpdate));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        agendamentoService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/buscar")
    public ResponseEntity<List<AgendamentoResponse>> buscarPorDataOuPeriodo(
            @RequestParam(required = false)
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
            LocalDate inicio,
            @RequestParam(required = false)
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
            LocalDate fim
    ) {
        List<AgendamentoResponse> resultados = agendamentoService.buscarPorDataOuPeriodo(inicio, fim);
        return ResponseEntity.ok(resultados);
    }
}
