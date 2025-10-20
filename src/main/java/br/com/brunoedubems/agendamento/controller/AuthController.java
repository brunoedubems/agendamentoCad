package br.com.brunoedubems.agendamento.controller;

import br.com.brunoedubems.agendamento.config.TokenService;
import br.com.brunoedubems.agendamento.dto.usuario.LoginRequest;
import br.com.brunoedubems.agendamento.dto.usuario.LoginResponse;
import br.com.brunoedubems.agendamento.dto.usuario.UsuarioRequest;
import br.com.brunoedubems.agendamento.dto.usuario.UsuarioResponse;
import br.com.brunoedubems.agendamento.entity.Usuario;
import br.com.brunoedubems.agendamento.service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuario/auth")
public class AuthController {

    private final UsuarioService usuarioService;
    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;

    public AuthController(UsuarioService usuarioService, AuthenticationManager authenticationManager, TokenService tokenService) {
        this.usuarioService = usuarioService;
        this.authenticationManager = authenticationManager;
        this.tokenService = tokenService;
    }

    @PostMapping("/register")
    public ResponseEntity<UsuarioResponse> register(@RequestBody UsuarioRequest usuarioRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.save(usuarioRequest));
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest) {
        UsernamePasswordAuthenticationToken UsuarioAndSenha = new UsernamePasswordAuthenticationToken(loginRequest.email(), loginRequest.senha());
        Authentication authenticate = authenticationManager.authenticate(UsuarioAndSenha);
        Usuario usuario = (Usuario) authenticate.getPrincipal();
        String token = tokenService.generateToken(usuario);

        return ResponseEntity.ok(new LoginResponse(token));
    }

}
