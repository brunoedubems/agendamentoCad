package br.com.brunoedubems.agendamento.entity;

import br.com.brunoedubems.agendamento.enums.StatusAgendamento;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "agendamento")
public class Agendamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome_cidadao", nullable = false)
    private String nomeCidadao;

    @Column(nullable = false, unique = true	)
    private Integer cpf;
    private String logradouro;
    private String numero;
    private String bairro;
    private String nis;
    private String telefone;

    @Column(name = "data_hora_entrevista", nullable = false)
    private LocalDateTime dataHoraEntrevista;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusAgendamento status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "entrevistador_id", nullable = false)
    private Entrevistador entrevistador;

    @Column(name = "criado_em", nullable = false, updatable = false)
    private LocalDateTime criadoEm = LocalDateTime.now();

    @Column(name = "atualizado_em")
    private LocalDateTime atualizadoEm;


}
