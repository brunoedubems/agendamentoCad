package br.com.brunoedubems.agendamento.dto.agendamento;

import br.com.brunoedubems.agendamento.dto.Entrevistador.EntrevistadorResumo;
import br.com.brunoedubems.agendamento.enums.StatusAgendamento;

import java.time.LocalDateTime;

public record AgendamentoResponse(
        Long id,
        String nomeCidadao,
        String cpf,
        String logradouro,
        String numero,
        String bairro,
        String nis,
        String telefone,
        LocalDateTime dataHoraEntrevista,
        StatusAgendamento status,
        EntrevistadorResumo entrevistadorResumo,
        LocalDateTime criadoEm,
        LocalDateTime atualizadoEm
) { }
