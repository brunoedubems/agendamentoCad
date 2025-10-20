package br.com.brunoedubems.agendamento.mapper;

import br.com.brunoedubems.agendamento.dto.usuario.UsuarioRequest;
import br.com.brunoedubems.agendamento.dto.usuario.UsuarioResponse;
import br.com.brunoedubems.agendamento.entity.Usuario;
import org.springframework.stereotype.Component;

@Component
public class UsuarioMapper {

    public Usuario toUsuario(UsuarioRequest usuarioRequest) {
        Usuario usuario = new Usuario();
        usuario.setNome(usuarioRequest.nome());
        usuario.setEmail(usuarioRequest.email());
        usuario.setSenha(usuarioRequest.senha());

        return usuario;
    }

    public UsuarioResponse toUsuarioResponse(Usuario usuario) {
        return new UsuarioResponse(
                usuario.getId(),
                usuario.getNome(),
                usuario.getEmail(),
                usuario.getSenha());
    }
}
