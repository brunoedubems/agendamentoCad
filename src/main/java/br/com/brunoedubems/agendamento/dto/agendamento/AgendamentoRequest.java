package br.com.brunoedubems.agendamento.dto.agendamento;

import br.com.brunoedubems.agendamento.enums.StatusAgendamento;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public record AgendamentoRequest(
        String nomeCidadao,
        String cpf,
        String logradouro,
        String numero,
        String bairro,
        String nis,
        String telefone,
        StatusAgendamento status,
        @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
        LocalDateTime dataHoraEntrevista,
        Long entrevistadorId
) {
}
