package br.com.brunoedubems.agendamento.mapper;

import br.com.brunoedubems.agendamento.dto.entrevistador.EntrevistadorRequest;
import br.com.brunoedubems.agendamento.dto.entrevistador.EntrevistadorResponse;
import br.com.brunoedubems.agendamento.dto.entrevistador.EntrevistadorResumo;
import br.com.brunoedubems.agendamento.dto.entrevistador.EntrevistadorUpdateRequest;
import br.com.brunoedubems.agendamento.entity.Entrevistador;
import org.springframework.stereotype.Component;

@Component
public class EntrevistadorMapper {
    public EntrevistadorResponse toResponse(Entrevistador entity) {
        return new EntrevistadorResponse(
                entity.getId(),
                entity.getNome(),
                entity.getCpf(),
                entity.isAtivo(),
                entity.getCriadoEm(),
                entity.getAtualizadoEm()
        );
    }

    public Entrevistador toEntity(EntrevistadorRequest dto) {
        Entrevistador entrevistador = new Entrevistador();
        entrevistador.setNome(dto.nome());
        entrevistador.setCpf(dto.cpf());
        entrevistador.setAtivo(dto.ativo());
        return entrevistador;
    }

    public Entrevistador updateEntityFromDto(EntrevistadorUpdateRequest dto, Entrevistador entity) {
        entity.setId(entity.getId());
        entity.setNome(dto.nome() != null ? dto.nome() : entity.getNome());
        entity.setCpf(dto.cpf() != null ? dto.cpf() : entity.getCpf());
        entity.setAtivo(dto.ativo() != null ? dto.ativo() : entity.isAtivo());
        return entity;
    }

    public EntrevistadorResumo toResponseResume(Entrevistador entity) {
        return new EntrevistadorResumo(
                entity.getId(),
                entity.getNome()
        );
    }

}
