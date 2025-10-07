package br.com.brunoedubems.agendamento.controller;

import br.com.brunoedubems.agendamento.dto.agendamento.AgendamentoRequest;
import br.com.brunoedubems.agendamento.dto.agendamento.AgendamentoResponse;
import br.com.brunoedubems.agendamento.dto.agendamento.AgendamentoUpdate;
import br.com.brunoedubems.agendamento.entity.Agendamento;
import br.com.brunoedubems.agendamento.entity.Entrevistador;
import br.com.brunoedubems.agendamento.service.AgendamentoService;
import br.com.brunoedubems.agendamento.service.EntrevistadorService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/agendamentos")
public class AgendamentoController {

    private final AgendamentoService agendamentoService;
    private final EntrevistadorService entrevistadorService;

    public AgendamentoController(AgendamentoService agendamentoService, EntrevistadorService entrevistadorService) {
        this.agendamentoService = agendamentoService;
        this.entrevistadorService = entrevistadorService;
    }

    @PostMapping
    public ResponseEntity<AgendamentoResponse> criar(@Valid @RequestBody AgendamentoRequest agendamentoRequest) {
        AgendamentoResponse agendamentoSalvo = agendamentoService.save(agendamentoRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(agendamentoSalvo);
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
                                                      @RequestBody @Valid AgendamentoUpdate agendamentoUpdate) {
        return ResponseEntity.ok(agendamentoService.update(id, agendamentoUpdate));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        agendamentoService.delete(id);
        return ResponseEntity.noContent().build();
    }


}
