package br.com.brunoedubems.agendamento.dto.usuario;

public record UsuarioResponse(
        Long id,
        String nome,
        String email,
        String senha
) {
}
