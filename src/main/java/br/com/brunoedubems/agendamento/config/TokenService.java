package br.com.brunoedubems.agendamento.config;

import br.com.brunoedubems.agendamento.entity.Usuario;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.Optional;

@Component
public class TokenService {

    @Value("${agendamento.security.secret}")
    private String secret;

    public String generateToken(Usuario usuario) {
        Algorithm algorithm = Algorithm.HMAC256(secret);
        return JWT.create()
                .withSubject(usuario.getEmail())
                .withClaim("nome", usuario.getNome())
                .withClaim("userId", usuario.getId())
                .withExpiresAt(Instant.now().plusSeconds(86400))
                .withIssuedAt(Instant.now())
                .withIssuer("Api Agendamento")
                .sign(algorithm);
    }

    public Optional<JWTUserData> verifyToken(String token) {
        try {
        Algorithm algorithm = Algorithm.HMAC256(secret);

        DecodedJWT jwt = JWT.require(algorithm)
                .build()
                .verify(token);

        JWTUserData jwtUserData = new JWTUserData(
                jwt.getClaim("userId").asLong(),
                jwt.getClaim("nome").asString(),
                jwt.getSubject());

        return Optional.of(jwtUserData);

        }catch (JWTVerificationException ex){
            return Optional.empty();
        }
    }
}
