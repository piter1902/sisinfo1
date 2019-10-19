-- Fichero SQL para la creacion de tablas

CREATE TABLE usuario
(
    login VARCHAR(20) NOT NULL,
    nombre VARCHAR(20) NOT NULL,
    CONSTRAINT usuarioPK PRIMARY KEY(login)
);

CREATE TABLE comentario
(
    comentarioId BIGINT NOT NULL AUTO_INCREMENT,
    texto VARCHAR(250) NOT NULL,
    usuarioId VARCHAR(20),
    CONSTRAINT comentarioPK PRIMARY KEY (comentarioId)
    CONSTRAINT usuarioFK FOREIGN KEY (usuarioId) REFERENCES usuario(login)
);

