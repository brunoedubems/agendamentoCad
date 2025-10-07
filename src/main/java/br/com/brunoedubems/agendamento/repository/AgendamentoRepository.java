package br.com.brunoedubems.agendamento.repository;

import br.com.brunoedubems.agendamento.entity.Agendamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {
}
