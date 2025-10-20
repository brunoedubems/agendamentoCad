package br.com.brunoedubems.agendamento.repository;

import br.com.brunoedubems.agendamento.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<UserDetails> findUsuarioByEmail(String username);
}
