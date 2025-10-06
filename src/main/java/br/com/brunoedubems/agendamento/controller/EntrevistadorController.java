package br.com.brunoedubems.agendamento.controller;

import br.com.brunoedubems.agendamento.dto.Entrevistador.EntrevistadorRequest;
import br.com.brunoedubems.agendamento.dto.Entrevistador.EntrevistadorResponse;
import br.com.brunoedubems.agendamento.dto.Entrevistador.EntrevistadorResumo;
import br.com.brunoedubems.agendamento.service.EntrevistadorService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/entrevistador")
public class EntrevistadorController {

    private final EntrevistadorService entrevistadorService;

    public EntrevistadorController(EntrevistadorService entrevistadorService) {
        this.entrevistadorService = entrevistadorService;
    }

    @PostMapping
    public ResponseEntity<EntrevistadorResponse> create(@Valid @RequestBody EntrevistadorRequest entrevistadorRequest) {
        EntrevistadorResponse saved = entrevistadorService.save(entrevistadorRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EntrevistadorResponse> update( @PathVariable Long id, @RequestBody @Valid EntrevistadorResumo entrevistadorRequest) {
        return ResponseEntity.ok(entrevistadorService.update(id, entrevistadorRequest));
    }

    @Transactional(readOnly = true)
    @GetMapping
    public ResponseEntity<List<EntrevistadorResponse>> findAll(){
        return ResponseEntity.ok(entrevistadorService.findAll());
    }

    @Transactional(readOnly = true)
    @GetMapping("/{id}")
    public ResponseEntity<EntrevistadorResponse> findById(@PathVariable  Long id){
        return ResponseEntity.ok(entrevistadorService.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        entrevistadorService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
