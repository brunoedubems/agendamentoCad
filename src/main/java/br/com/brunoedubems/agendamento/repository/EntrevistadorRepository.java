package br.com.brunoedubems.agendamento.repository;

import br.com.brunoedubems.agendamento.entity.Entrevistador;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EntrevistadorRepository extends JpaRepository<Entrevistador, Long> {

    boolean existsByCpfAndIdNot(String cpf, Long id);

}
