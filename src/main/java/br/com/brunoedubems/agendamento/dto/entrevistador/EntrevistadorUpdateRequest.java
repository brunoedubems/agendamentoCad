package br.com.brunoedubems.agendamento.dto.entrevistador;

public record EntrevistadorUpdateRequest(
        String nome,
        String cpf,
        Boolean ativo
) {
}
