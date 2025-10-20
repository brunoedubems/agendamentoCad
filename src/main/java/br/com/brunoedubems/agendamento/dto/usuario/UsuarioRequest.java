package br.com.brunoedubems.agendamento.dto.usuario;

public record UsuarioRequest(
        String nome,
        String email,
        String senha
) {
}
