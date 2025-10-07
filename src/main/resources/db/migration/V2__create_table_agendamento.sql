CREATE TABLE agendamento (
    id BIGSERIAL PRIMARY KEY,
    nome_cidadao VARCHAR(255) NOT NULL,
    cpf VARCHAR(11) NOT NULL UNIQUE,
    logradouro VARCHAR(255),
    numero VARCHAR(50),
    bairro VARCHAR(255),
    nis VARCHAR(11),
    telefone VARCHAR(20),
    data_hora_entrevista TIMESTAMP,
    status VARCHAR(50) NOT NULL,
    entrevistador_id BIGINT NOT NULL,
    criado_em TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    atualizado_em TIMESTAMP,
    CONSTRAINT fk_agendamento_entrevistador
        FOREIGN KEY (entrevistador_id)
        REFERENCES entrevistador(id)
        ON DELETE RESTRICT
);
