# Proyecto Peliculas
Proyecto ingeniería del software

-Comandos usados
docker pull postgres:16
docker run --name pelibd -e POSTGRES_PASSWORD=123456 -p 15432:5432 -d postgres:16
docker exec -it -u postgres pelibd psql

-puertos
15432 mi maquina
5432
9999
9955

-Base de datos y pruebas
-- Tabla de Usuarios
CREATE TABLE usuarios (
    id serial PRIMARY KEY,
    nombreusuario VARCHAR(255) NOT NULL,
    contra VARCHAR(255) NOT NULL
);

-- Datos de prueba para la tabla de Usuarios
INSERT INTO usuarios (nombreusuario, contra) VALUES
    ('usuario1', 'contra1'),
    ('usuario2', 'contra2');
