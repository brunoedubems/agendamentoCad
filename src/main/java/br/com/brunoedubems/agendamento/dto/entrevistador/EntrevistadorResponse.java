package br.com.brunoedubems.agendamento.dto.entrevistador;

import java.time.LocalDateTime;

public record EntrevistadorResponse(
        Long id,
        String nome,
        String cpf,
        Boolean ativo,
        LocalDateTime criadoEm,
        LocalDateTime atualizadoEm
) { }
