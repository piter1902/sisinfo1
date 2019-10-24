-- Fichero SQL para la creacion de tablas

CREATE TABLE usuario
(
    login VARCHAR(20) NOT NULL,
    password varbinary(20) not null,
    nombre VARCHAR(20) NOT NULL,
    vehic_id integer,
    CONSTRAINT usuarioPK PRIMARY KEY(login),
    CONSTRAINT vehiculoFK FOREIGN KEY (vehic_id) REFERENCES vehiculo(id)
);

CREATE TABLE comentario
(
    comentarioId BIGINT NOT NULL AUTO_INCREMENT,
    texto VARCHAR(250) NOT NULL,
    usuarioId VARCHAR(20),
    CONSTRAINT comentarioPK PRIMARY KEY (comentarioId),
    CONSTRAINT usuarioFK FOREIGN KEY (usuarioId) REFERENCES usuario(login)
);


-- Para las consultas de rutas guardadas por el usuario
CREATE TABLE consulta
(
    id BIGINT not null AUTO_INCREMENT,
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
    id BIGINT not null,
    tipo VARCHAR(20) not null,
    euro_star varchar(10) not null,
    fuel varchar(10) not null,
    regist_year integer not null,
    CONSTRAINT vehiculoPK PRIMARY KEY (id)
);
