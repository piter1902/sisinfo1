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
    CONSTRAINT comentarioPK PRIMARY KEY (comentarioId),
    CONSTRAINT usuarioFK FOREIGN KEY (usuarioId) REFERENCES usuario(login)
);

-- Tablas que usaremos nosotros para la gestión de información
CREATE TABLE passwd
(
    login varchar(20) not null,
    password varbinary(20) not null,
    CONSTRAINT passwdPK PRIMARY KEY (login),
    CONSTRAINT usuarioFK FOREIGN KEY (login) REFERENCES usuario(login)
);

-- Para las consultas de rutas guardadas por el usuario
CREATE TABLE consulta
(
    id integer not null AUTO_INCREMENT,
    login varchar(20) not null,
    fecha date not null,
    origen varchar(40) not null,
    destino varchar(40) not null,
    CONSTRAINT consultaPK PRIMARY KEY (id, login),
    CONSTRAINT usuarioFK FOREIGN KEY (login) REFERENCES usuario(login)
);

-- Para la gestion del vehiculo del usuario
CREATE TABLE vehiculo
(
    -- Completar
);
