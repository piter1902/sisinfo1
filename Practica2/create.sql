-- Para la gestion del vehiculo del usuario
CREATE TABLE Vehiculo
(
    id BIGINT not null,
    tipo VARCHAR(20) not null,
    euro_star varchar(10) not null,
    fuel varchar(10) not null,
    regist_year integer not null,
    CONSTRAINT vehiculoPK PRIMARY KEY (id)
);

-- Fichero SQL para la creacion de tablas
CREATE TABLE Comentario
(
    comentarioId BIGINT NOT NULL AUTO_INCREMENT,
    texto VARCHAR(250) NOT NULL,
    email varchar(20) not null,
    nombre VARCHAR(20) not null,
    apellidos varchar(30),
    CONSTRAINT comentarioPK PRIMARY KEY (comentarioId)
);

CREATE TABLE Usuario
(
    login VARCHAR(20) NOT NULL,
    password varbinary(20) not null,
    nombre VARCHAR(20) NOT NULL,
    apellidos varchar(30),
    email VARCHAR(20) not null,
    vehic_id bigint not null,
    CONSTRAINT usuarioPK PRIMARY KEY (login),
    CONSTRAINT vehiculoFK FOREIGN KEY (vehic_id) REFERENCES Vehiculo(id)
);

-- Para las consultas de rutas guardadas por el usuario
CREATE TABLE Consulta
(
    id BIGINT not null AUTO_INCREMENT,
    login varchar(20) not null,
    fecha date not null,
    origen varchar(40) not null,
    destino varchar(40) not null,
    CONSTRAINT consultaPK PRIMARY KEY (id),
    CONSTRAINT usuarioFK FOREIGN KEY (login) REFERENCES Usuario(login)
);

