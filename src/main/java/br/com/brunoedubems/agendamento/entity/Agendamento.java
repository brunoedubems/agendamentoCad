package br.com.brunoedubems.agendamento.entity;

import br.com.brunoedubems.agendamento.enums.StatusAgendamento;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "agendamento")
public class Agendamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome_cidadao", nullable = false)
    private String nomeCidadao;

    @Column(nullable = false, unique = true	)
    private String cpf;
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
    private LocalDateTime criadoEm;

    @Column(name = "atualizado_em")
    private LocalDateTime atualizadoEm;

    public Agendamento() {
    }

    public Agendamento(Long id, String nomeCidadao, String cpf, String logradouro, String numero, String bairro, String nis, String telefone, LocalDateTime dataHoraEntrevista, StatusAgendamento status, Entrevistador entrevistador, LocalDateTime criadoEm, LocalDateTime atualizadoEm) {
        this.id = id;
        this.nomeCidadao = nomeCidadao;
        this.cpf = cpf;
        this.logradouro = logradouro;
        this.numero = numero;
        this.bairro = bairro;
        this.nis = nis;
        this.telefone = telefone;
        this.dataHoraEntrevista = dataHoraEntrevista;
        this.status = status;
        this.entrevistador = entrevistador;
        this.criadoEm = criadoEm;
        this.atualizadoEm = atualizadoEm;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeCidadao() {
        return nomeCidadao;
    }

    public void setNomeCidadao(String nomeCidadao) {
        this.nomeCidadao = nomeCidadao;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getNis() {
        return nis;
    }

    public void setNis(String nis) {
        this.nis = nis;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public LocalDateTime getDataHoraEntrevista() {
        return dataHoraEntrevista;
    }

    public void setDataHoraEntrevista(LocalDateTime dataHoraEntrevista) {
        this.dataHoraEntrevista = dataHoraEntrevista;
    }

    public StatusAgendamento getStatus() {
        return status;
    }

    public void setStatus(StatusAgendamento status) {
        this.status = status;
    }

    public Entrevistador getEntrevistador() {
        return entrevistador;
    }

    public void setEntrevistador(Entrevistador entrevistador) {
        this.entrevistador = entrevistador;
    }

    public LocalDateTime getCriadoEm() {
        return criadoEm;
    }

    public void setCriadoEm(LocalDateTime criadoEm) {
        this.criadoEm = criadoEm;
    }

    public LocalDateTime getAtualizadoEm() {
        return atualizadoEm;
    }

    public void setAtualizadoEm(LocalDateTime atualizadoEm) {
        this.atualizadoEm = atualizadoEm;
    }

    @PrePersist
    protected void onCreate() {
        criadoEm = LocalDateTime.now();
        atualizadoEm = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        atualizadoEm = LocalDateTime.now();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Agendamento that = (Agendamento) o;
        return Objects.equals(id, that.id) && Objects.equals(nomeCidadao, that.nomeCidadao) && Objects.equals(cpf, that.cpf) && Objects.equals(logradouro, that.logradouro) && Objects.equals(numero, that.numero) && Objects.equals(bairro, that.bairro) && Objects.equals(nis, that.nis) && Objects.equals(telefone, that.telefone) && Objects.equals(dataHoraEntrevista, that.dataHoraEntrevista) && status == that.status && Objects.equals(entrevistador, that.entrevistador) && Objects.equals(criadoEm, that.criadoEm) && Objects.equals(atualizadoEm, that.atualizadoEm);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nomeCidadao, cpf, logradouro, numero, bairro, nis, telefone, dataHoraEntrevista, status, entrevistador, criadoEm, atualizadoEm);
    }


}
