package br.com.brunoedubems.agendamento.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "entrevistador")
public class Entrevistador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false, unique = true	)
    private String cpf;

    @Column(nullable = false)
    private boolean ativo = true;

    @Column(name = "criado_em", nullable = false, updatable = false)
    private LocalDateTime criadoEm = LocalDateTime.now();

    @Column(name = "atualizado_em")
    private LocalDateTime atualizadoEm;

}
