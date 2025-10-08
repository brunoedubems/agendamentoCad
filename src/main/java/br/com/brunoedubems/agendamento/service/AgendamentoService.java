package br.com.brunoedubems.agendamento.service;

import br.com.brunoedubems.agendamento.dto.agendamento.AgendamentoRequest;
import br.com.brunoedubems.agendamento.dto.agendamento.AgendamentoResponse;
import br.com.brunoedubems.agendamento.dto.agendamento.AgendamentoUpdate;
import br.com.brunoedubems.agendamento.entity.Agendamento;
import br.com.brunoedubems.agendamento.entity.Entrevistador;
import br.com.brunoedubems.agendamento.mapper.AgendamentoMapper;
import br.com.brunoedubems.agendamento.repository.AgendamentoRepository;
import br.com.brunoedubems.agendamento.repository.EntrevistadorRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Service
public class AgendamentoService {

    private final AgendamentoRepository agendamentoRepository;
    private final EntrevistadorRepository entrevistadorRepository;
    private final AgendamentoMapper mapper;

    public AgendamentoService(AgendamentoRepository agendamentoRepository, EntrevistadorRepository entrevistadorRepository, AgendamentoMapper mapper) {
        this.agendamentoRepository = agendamentoRepository;
        this.entrevistadorRepository = entrevistadorRepository;
        this.mapper = mapper;
    }

    @Transactional
    public AgendamentoResponse save(AgendamentoRequest agendamentoRequest) {
        Agendamento agendamento = mapper.toEntity(agendamentoRequest);
        Entrevistador entrevistador = entrevistadorRepository.findById(agendamentoRequest.entrevistadorId())
                .orElseThrow(() -> new EntityNotFoundException("Agendamento não encontrado com id " + agendamentoRequest.entrevistadorId()));
        agendamento.setEntrevistador(entrevistador);
        return mapper.toResponse(agendamentoRepository.save(agendamento));
    }

    @Transactional(readOnly = true)
    public List<AgendamentoResponse> findAll() {
        return agendamentoRepository.findAll()
                .stream()
                .map(mapper::toResponse).toList();
    }

    @Transactional(readOnly = true)
    public AgendamentoResponse findById(Long id) {
        Agendamento agendamento = agendamentoRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Agendamento não encontrado com ID: " + id));
        return mapper.toResponse(agendamento);
    }

    @Transactional()
    public AgendamentoResponse update(Long id, AgendamentoUpdate entrevistadorRequest) {
        Agendamento entity = agendamentoRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Agendamento não encontrado com ID: " + id));
        Agendamento entidadeAtualizada = mapper.updateEntityFromDto(entrevistadorRequest, entity);
        return mapper.toResponse(agendamentoRepository.save(entidadeAtualizada));
    }

    @Transactional()
    public void delete(Long id) {
        agendamentoRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
        public List<AgendamentoResponse> buscarPorDataOuPeriodo(LocalDate inicio, LocalDate fim) {
        LocalDateTime inicioDoDia = inicio.atStartOfDay();
        LocalDateTime fimDoDia = (fim != null) ? fim.atTime(LocalTime.MAX) : inicio.atTime(LocalTime.MAX);

        return agendamentoRepository.findByDataHoraEntrevistaBetween(inicioDoDia, fimDoDia)
                .stream()
                .map(mapper::toResponse).toList();

    }

}
