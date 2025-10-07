package br.com.brunoedubems.agendamento.mapper;

import br.com.brunoedubems.agendamento.dto.Entrevistador.EntrevistadorResumo;
import br.com.brunoedubems.agendamento.dto.agendamento.AgendamentoRequest;
import br.com.brunoedubems.agendamento.dto.agendamento.AgendamentoResponse;
import br.com.brunoedubems.agendamento.dto.agendamento.AgendamentoUpdate;
import br.com.brunoedubems.agendamento.entity.Agendamento;
import org.springframework.stereotype.Component;

@Component
public class AgendamentoMapper {

    public AgendamentoResponse toResponse(Agendamento agendamento) {

        EntrevistadorResumo entrevistadorResumo = new EntrevistadorResumo(
                agendamento.getEntrevistador().getId(),
                agendamento.getEntrevistador().getNome()
        );

        return new AgendamentoResponse(
                agendamento.getId(),
                agendamento.getNomeCidadao(),
                agendamento.getCpf(),
                agendamento.getLogradouro(),
                agendamento.getNumero(),
                agendamento.getBairro(),
                agendamento.getNis(),
                agendamento.getTelefone(),
                agendamento.getDataHoraEntrevista(),
                agendamento.getStatus(),
                entrevistadorResumo,
                agendamento.getCriadoEm(),
                agendamento.getAtualizadoEm()
        );
    }

    public Agendamento toEntity(AgendamentoRequest dto) {
        Agendamento agendamento = new Agendamento();
        agendamento.setNomeCidadao(dto.nomeCidadao());
        agendamento.setCpf(dto.cpf());
        agendamento.setLogradouro(dto.logradouro());
        agendamento.setNumero(dto.numero());
        agendamento.setBairro(dto.bairro());
        agendamento.setNis(dto.nis());
        agendamento.setTelefone(dto.telefone());
        agendamento.setDataHoraEntrevista(dto.dataHoraEntrevista());
        agendamento.setStatus(dto.status());
        return agendamento;
    }

    public Agendamento updateEntityFromDto(AgendamentoUpdate dto, Agendamento entity) {
        entity.setId(entity.getId());
        entity.setNomeCidadao(dto.nomeCidadao() != null ? dto.nomeCidadao() : entity.getNomeCidadao());
        entity.setCpf(dto.cpf() != null ? dto.cpf() : entity.getCpf());
        entity.setLogradouro(dto.logradouro() != null ? dto.logradouro() : entity.getLogradouro());
        entity.setNumero(dto.numero() != null ? dto.numero() : entity.getNumero());
        entity.setBairro(dto.bairro() != null ? dto.bairro() : entity.getBairro());
        entity.setNis(dto.bairro() != null ? dto.nis() : entity.getNis());
        entity.setNis(dto.telefone() != null ? dto.telefone() : entity.getTelefone());
        entity.setStatus(dto.status() != null ? dto.status() : entity.getStatus());
        return entity;
    }

}
