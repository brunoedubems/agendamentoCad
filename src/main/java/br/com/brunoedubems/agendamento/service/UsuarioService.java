package br.com.brunoedubems.agendamento.service;

import br.com.brunoedubems.agendamento.dto.usuario.UsuarioRequest;
import br.com.brunoedubems.agendamento.dto.usuario.UsuarioResponse;
import br.com.brunoedubems.agendamento.entity.Usuario;
import br.com.brunoedubems.agendamento.mapper.UsuarioMapper;
import br.com.brunoedubems.agendamento.repository.UsuarioRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final UsuarioMapper usuarioMapper;
    private final PasswordEncoder passwordEncoder;

    public UsuarioService(UsuarioRepository usuarioRepository, UsuarioMapper usuarioMapper, PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.usuarioMapper = usuarioMapper;
        this.passwordEncoder = passwordEncoder;
    }

    public UsuarioResponse save(UsuarioRequest usuario) {
        Usuario usuarioSalvo = usuarioMapper.toUsuario(usuario);
        usuarioSalvo.setSenha(passwordEncoder.encode(usuario.senha()));
        return usuarioMapper.toUsuarioResponse(usuarioRepository.save(usuarioSalvo));
    }

}
