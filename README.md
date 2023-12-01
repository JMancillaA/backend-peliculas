# Proyecto Peliculas
Proyecto ingeniería del software

-Comandos usados
docker pull postgres:16
docker run --name pelibd -e POSTGRES_PASSWORD=123456 -p 15432:5432 -d postgres:16
docker exec -it -u postgres pelibd psql
\dt

-puertos
15432 mi maquina
5432
9999
9955

-Base de datos y pruebas
-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2023-11-27 18:59:59.82

-- tables
-- Table: actores
CREATE TABLE actores (
    id int  NOT NULL,
    nombre varchar(55)  NOT NULL,
    id_TMDB varchar(25)  NOT NULL,
    CONSTRAINT actores_pk PRIMARY KEY (id)
);

-- Table: comentarios
CREATE TABLE comentarios (
    id int  NOT NULL,
    valoracion_id int  NOT NULL,
    usuarios_id int  NOT NULL,
    fecha date  NOT NULL,
    comentario varchar(255)  NOT NULL,
    peliculasTMDB_id int  NOT NULL,
    CONSTRAINT comentarios_pk PRIMARY KEY (id)
);

-- Table: directores
CREATE TABLE directores (
    id int  NOT NULL,
    nombre varchar(55)  NOT NULL,
    id_TMDB varchar(25)  NOT NULL,
    CONSTRAINT directores_pk PRIMARY KEY (id)
);

-- Table: generos
CREATE TABLE generos (
    id int  NOT NULL,
    genero varchar(55)  NOT NULL,
    CONSTRAINT generos_pk PRIMARY KEY (id)
);

-- Table: peliculasTMDB
CREATE TABLE peliculasTMDB (
    id int  NOT NULL,
    actores_id int  NOT NULL,
    directores_id int  NOT NULL,
    generos_id int  NOT NULL,
    fecha_lanzamiento date  NOT NULL,
    titulo varchar(55)  NOT NULL,
    sinopsis varchar(1000)  NOT NULL,
    poster varchar(255)  NOT NULL,
    valoracion varchar(25)  NOT NULL,
    id_TMDB varchar(25)  NOT NULL,
    recomendada boolean  NOT NULL,
    CONSTRAINT peliculasTMDB_pk PRIMARY KEY (id)
);

-- Table: peliculas_por_ver
CREATE TABLE peliculas_por_ver (
    id int  NOT NULL,
    usuarios_id int  NOT NULL,
    peliculasTMDB_id int  NOT NULL,
    fechamarcada date  NOT NULL,
    CONSTRAINT peliculas_por_ver_pk PRIMARY KEY (id)
);

-- Table: peliculas_recomendadas_con_exito
CREATE TABLE peliculas_recomendadas_con_exito (
    id int  NOT NULL,
    peliculasTMDB_id int  NOT NULL,
    usuarios_id int  NOT NULL,
    valoracion_id int  NOT NULL,
    fecha date  NOT NULL,
    prompt_usado varchar(1000)  NOT NULL,
    prompt_devuelto varchar(1000)  NOT NULL,
    CONSTRAINT peliculas_recomendadas_con_exito_pk PRIMARY KEY (id)
);

-- Table: peliculas_vistas
CREATE TABLE peliculas_vistas (
    id int  NOT NULL,
    usuarios_id int  NOT NULL,
    peliculasTMDB_id int  NOT NULL,
    fechavista date  NOT NULL,
    CONSTRAINT peliculas_vistas_pk PRIMARY KEY (id)
);

-- Table: usuarios
CREATE TABLE usuarios (
    id int  NOT NULL,
    nombre varchar(55)  NOT NULL,
    email varchar(55)  NOT NULL,
    contra varchar(55)  NOT NULL,
    fecha_nacimiento date  NOT NULL,
    fecha_creacion date  NOT NULL,
    pais varchar(55)  NOT NULL,
    estado boolean  NOT NULL,
    auth int  NOT NULL,
    CONSTRAINT usuarios_pk PRIMARY KEY (id)
);

-- Table: valoraciones
CREATE TABLE valoraciones (
    id int  NOT NULL,
    peliculas_vistas_id int  NOT NULL,
    usuarios_id int  NOT NULL,
    peliculasTMDB_id int  NOT NULL,
    fecha_valorada date  NOT NULL,
    valoracion varchar(10)  NOT NULL,
    CONSTRAINT valoraciones_pk PRIMARY KEY (id)
);

-- foreign keys
-- Reference: comentarios_peliculasTMDB (table: comentarios)
ALTER TABLE comentarios ADD CONSTRAINT comentarios_peliculasTMDB
    FOREIGN KEY (peliculasTMDB_id)
    REFERENCES peliculasTMDB (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: comentarios_usuarios (table: comentarios)
ALTER TABLE comentarios ADD CONSTRAINT comentarios_usuarios
    FOREIGN KEY (usuarios_id)
    REFERENCES usuarios (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: comentarios_valoracion (table: comentarios)
ALTER TABLE comentarios ADD CONSTRAINT comentarios_valoracion
    FOREIGN KEY (valoracion_id)
    REFERENCES valoraciones (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: peliculasTMDB_actores (table: peliculasTMDB)
ALTER TABLE peliculasTMDB ADD CONSTRAINT peliculasTMDB_actores
    FOREIGN KEY (actores_id)
    REFERENCES actores (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: peliculasTMDB_directores (table: peliculasTMDB)
ALTER TABLE peliculasTMDB ADD CONSTRAINT peliculasTMDB_directores
    FOREIGN KEY (directores_id)
    REFERENCES directores (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: peliculasTMDB_generos (table: peliculasTMDB)
ALTER TABLE peliculasTMDB ADD CONSTRAINT peliculasTMDB_generos
    FOREIGN KEY (generos_id)
    REFERENCES generos (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: peliculas_por_ver_peliculasTMDB (table: peliculas_por_ver)
ALTER TABLE peliculas_por_ver ADD CONSTRAINT peliculas_por_ver_peliculasTMDB
    FOREIGN KEY (peliculasTMDB_id)
    REFERENCES peliculasTMDB (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: peliculas_por_ver_usuarios (table: peliculas_por_ver)
ALTER TABLE peliculas_por_ver ADD CONSTRAINT peliculas_por_ver_usuarios
    FOREIGN KEY (usuarios_id)
    REFERENCES usuarios (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: peliculas_recomendadas_con_exito_peliculasTMDB (table: peliculas_recomendadas_con_exito)
ALTER TABLE peliculas_recomendadas_con_exito ADD CONSTRAINT peliculas_recomendadas_con_exito_peliculasTMDB
    FOREIGN KEY (peliculasTMDB_id)
    REFERENCES peliculasTMDB (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: peliculas_recomendadas_con_exito_usuarios (table: peliculas_recomendadas_con_exito)
ALTER TABLE peliculas_recomendadas_con_exito ADD CONSTRAINT peliculas_recomendadas_con_exito_usuarios
    FOREIGN KEY (usuarios_id)
    REFERENCES usuarios (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: peliculas_recomendadas_con_exito_valoracion (table: peliculas_recomendadas_con_exito)
ALTER TABLE peliculas_recomendadas_con_exito ADD CONSTRAINT peliculas_recomendadas_con_exito_valoracion
    FOREIGN KEY (valoracion_id)
    REFERENCES valoraciones (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: peliculas_vistas_peliculasTMDB (table: peliculas_vistas)
ALTER TABLE peliculas_vistas ADD CONSTRAINT peliculas_vistas_peliculasTMDB
    FOREIGN KEY (peliculasTMDB_id)
    REFERENCES peliculasTMDB (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: peliculas_vistas_usuarios (table: peliculas_vistas)
ALTER TABLE peliculas_vistas ADD CONSTRAINT peliculas_vistas_usuarios
    FOREIGN KEY (usuarios_id)
    REFERENCES usuarios (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: valoracion_peliculasTMDB (table: valoraciones)
ALTER TABLE valoraciones ADD CONSTRAINT valoracion_peliculasTMDB
    FOREIGN KEY (peliculasTMDB_id)
    REFERENCES peliculasTMDB (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: valoracion_peliculas_vistas (table: valoraciones)
ALTER TABLE valoraciones ADD CONSTRAINT valoracion_peliculas_vistas
    FOREIGN KEY (peliculas_vistas_id)
    REFERENCES peliculas_vistas (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: valoracion_usuarios (table: valoraciones)
ALTER TABLE valoraciones ADD CONSTRAINT valoracion_usuarios
    FOREIGN KEY (usuarios_id)
    REFERENCES usuarios (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- End of file.

-- Ejemplo 1
INSERT INTO usuarios (id, nombre, email, contra, fecha_nacimiento, fecha_creacion, pais, estado, auth)
VALUES (1, 'Usuario1', 'usuario1@example.com', 'contra1', '2000-01-01', '2023-12-01', 'Bolivia', true, 0);

-- Ejemplo 2
INSERT INTO usuarios (id, nombre, email, contra, fecha_nacimiento, fecha_creacion, pais, estado, auth)
VALUES (2, 'Usuario2', 'usuario2@example.com', 'contra2', '1995-05-15', '2023-12-01', 'Chile', true, 0);

-- Ejemplo 3
INSERT INTO usuarios (id, nombre, email, contra, fecha_nacimiento, fecha_creacion, pais, estado, auth)
VALUES (3, 'Usuario3', 'usuario3@example.com', 'contra3', '1988-08-30', '2023-12-01', 'Peru', true, 0);
