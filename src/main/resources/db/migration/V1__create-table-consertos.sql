CREATE TABLE consertos (
    id BIGINT NOT NULL AUTO_INCREMENT,
    data_entrada_oficina DATE NOT NULL,
    data_saida_oficina DATE,

    nome VARCHAR(100) NOT NULL,
    anos_experiencia INT NOT NULL,

    marca VARCHAR(50) NOT NULL,
    modelo VARCHAR(100) NOT NULL,
    ano INT NOT NULL,

    PRIMARY KEY (id)
);