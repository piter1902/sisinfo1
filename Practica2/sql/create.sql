-- Para la gestion del vehiculo del usuario
CREATE TABLE Vehiculo
(
    id BIGINT not null AUTO_INCREMENT,
    tipo VARCHAR(25),
    segment varchar(35) not null,
    euro_star varchar(25) not null,
    engine_type varchar(10),
    fuel varchar(20) not null,
    pollutant varchar(5) not null,
    emission_factor float not null,
    CONSTRAINT vehiculoPK PRIMARY KEY (id)
);

-- tabla de gestion de los comentarios que se dejan en la seccion "Help & Contact"
CREATE TABLE Comentario
(
    comentarioId BIGINT NOT NULL AUTO_INCREMENT,
    texto VARCHAR(250) NOT NULL,
    email varchar(30) not null,
    nombre VARCHAR(20) not null,
    apellidos varchar(30),
    antecesor bigint,
    CONSTRAINT comentarioPK PRIMARY KEY (comentarioId),
    CONSTRAINT ComentarioFK FOREIGN KEY (antecesor) REFERENCES Comentario(comentarioId)
);

-- Usar funciones de encriptacion para el password
CREATE TABLE Usuario
(
    login VARCHAR(20) NOT NULL,
    password varchar(50) not null,
    nombre VARCHAR(20) NOT NULL,
    apellidos varchar(30),
    email VARCHAR(50) not null,
    vehic_id bigint not null,
    CONSTRAINT usuarioPK PRIMARY KEY (login),
    CONSTRAINT vehiculoFK FOREIGN KEY (vehic_id) REFERENCES Vehiculo(id) on delete cascade
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
    CONSTRAINT usuarioFK FOREIGN KEY (login) REFERENCES Usuario(login) on delete cascade
);

alter table Vehiculo AUTO_INCREMENT = 1;
alter table Comentario AUTO_INCREMENT = 1;
alter table Consulta AUTO_INCREMENT = 1;

-- Insercion para que comentario funcione
insert into Comentario(comentarioId, texto, email, nombre, apellidos, antecesor) values (1, "Esto solo es referenciado por los mensajes de Usuarios", "ecobicizara@gmail.com", "ecobicizara", "ecobicizara", NULL);