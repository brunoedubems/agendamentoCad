package br.com.brunoedubems.agendamento.service;

import br.com.brunoedubems.agendamento.dto.Entrevistador.EntrevistadorRequest;
import br.com.brunoedubems.agendamento.dto.Entrevistador.EntrevistadorResponse;
import br.com.brunoedubems.agendamento.dto.Entrevistador.EntrevistadorResumo;
import br.com.brunoedubems.agendamento.entity.Entrevistador;
import br.com.brunoedubems.agendamento.mapper.EntrevistadorMapper;
import br.com.brunoedubems.agendamento.repository.EntrevistadorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntrevistadorService {

    private final EntrevistadorRepository repository;
    private final EntrevistadorMapper entrevistadorMapper;

    public EntrevistadorService(EntrevistadorRepository repository, EntrevistadorMapper entrevistadorMapper) {
        this.repository = repository;
        this.entrevistadorMapper = entrevistadorMapper;
    }

    public EntrevistadorResponse save(EntrevistadorRequest entrevistadorRequest) {
        Entrevistador entrevistadorSalvo = repository.save(entrevistadorMapper.toEntity(entrevistadorRequest));
        return entrevistadorMapper.toResponse(entrevistadorSalvo);
    }

    public EntrevistadorResponse update(Long id, EntrevistadorResumo entrevistadorRequest) {
        Entrevistador entity = repository.findById(id).orElseThrow(() -> new RuntimeException("Entrevistador não encontrado com id: " + id));
        Entrevistador entidadeAtualizada = entrevistadorMapper.updateEntityFromDto(entrevistadorRequest, entity);
        return entrevistadorMapper.toResponse(repository.save(entidadeAtualizada));
    }


    public List<EntrevistadorResponse> findAll() {
        return repository.findAll()
                .stream()
                .map(entrevistadorMapper::toResponse)
                .toList();
    }

    public EntrevistadorResponse findById(Long id) {
        Entrevistador entrevistador = repository.findById(id).orElseThrow(() -> new RuntimeException("Entrevistador não encontrado com ID: " + id));
        return entrevistadorMapper.toResponse(entrevistador);
    }

    public void delete(Long id) {
        Entrevistador entrevistador = repository.findById(id).orElseThrow(() -> new RuntimeException("Entrevistador não encontrado com ID: " + id));
        entrevistador.setAtivo(false);
    }


}
