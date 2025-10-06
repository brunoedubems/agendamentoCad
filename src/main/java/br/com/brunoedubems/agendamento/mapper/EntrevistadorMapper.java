package br.com.brunoedubems.agendamento.mapper;

import br.com.brunoedubems.agendamento.dto.Entrevistador.EntrevistadorRequest;
import br.com.brunoedubems.agendamento.dto.Entrevistador.EntrevistadorResponse;
import br.com.brunoedubems.agendamento.dto.Entrevistador.EntrevistadorResumo;
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

    public Entrevistador updateEntityFromDto(EntrevistadorResumo dto, Entrevistador entity) {
        entity.setId(entity.getId());
        entity.setNome(dto.nome() != null ? dto.nome() : entity.getNome());
        return entity;
    }

}
