package br.com.brunoedubems.agendamento.config;

import lombok.Builder;

public record JWTUserData(Long id, String nome, String email) {
}
