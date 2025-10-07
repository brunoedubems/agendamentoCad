package br.com.brunoedubems.agendamento.service;

import br.com.brunoedubems.agendamento.dto.Entrevistador.EntrevistadorRequest;
import br.com.brunoedubems.agendamento.dto.Entrevistador.EntrevistadorResponse;
import br.com.brunoedubems.agendamento.dto.Entrevistador.EntrevistadorResumo;
import br.com.brunoedubems.agendamento.entity.Entrevistador;
import br.com.brunoedubems.agendamento.mapper.EntrevistadorMapper;
import br.com.brunoedubems.agendamento.repository.EntrevistadorRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EntrevistadorService {

    private final EntrevistadorRepository repository;
    private final EntrevistadorMapper mapper;

    public EntrevistadorService(EntrevistadorRepository repository, EntrevistadorMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public EntrevistadorResponse save(EntrevistadorRequest entrevistadorRequest) {
        Entrevistador entrevistadorSalvo = repository.save(mapper.toEntity(entrevistadorRequest));
        return mapper.toResponse(entrevistadorSalvo);
    }

    public EntrevistadorResponse update(Long id, EntrevistadorResumo entrevistadorRequest) {
        Entrevistador entity = repository.findById(id).orElseThrow(() -> new RuntimeException("Entrevistador não encontrado com id: " + id));
        Entrevistador entidadeAtualizada = mapper.updateEntityFromDto(entrevistadorRequest, entity);
        return mapper.toResponse(repository.save(entidadeAtualizada));
    }

    @Transactional(readOnly = true)
    public List<EntrevistadorResponse> findAll() {
        return repository.findAll()
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    @Transactional(readOnly = true)
    public EntrevistadorResponse findById(Long id) {
        Entrevistador entrevistador = repository.findById(id).orElseThrow(() -> new RuntimeException("Entrevistador não encontrado com ID: " + id));
        return mapper.toResponse(entrevistador);
    }

    public void delete(Long id) {
        Entrevistador entrevistador = repository.findById(id).orElseThrow(() -> new RuntimeException("Entrevistador não encontrado com ID: " + id));
        entrevistador.setAtivo(false);
    }



}
