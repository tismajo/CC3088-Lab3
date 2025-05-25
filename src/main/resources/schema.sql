CREATE TYPE estado_animo AS ENUM ('FELIZ', 'TRISTE', 'RELAJADO', 'ENERGICO', 'MELANCOLICO');
CREATE TYPE formato_audio AS ENUM ('MP3', 'FLAC', 'WAV', 'AAC');

CREATE TABLE cantante_model (
    id SERIAL PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL UNIQUE,
    nacionalidad VARCHAR(50),
    fecha_nacimiento DATE
);

CREATE TABLE genero_model (
    id SERIAL PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL UNIQUE
);

CREATE TABLE album_model (
    id SERIAL PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    anio INTEGER,
    cantante_id INTEGER REFERENCES cantante_model(id)
);

CREATE TABLE cancion_model (
    id SERIAL PRIMARY KEY,
    titulo VARCHAR(150) NOT NULL,
    cantante_id INTEGER REFERENCES cantante_model(id),
    album_id INTEGER REFERENCES album_model(id),
    tiempo_duracion INTERVAL NOT NULL,
    formato formato_audio NOT NULL,
    genero_id INTEGER REFERENCES genero_model(id)
);

CREATE TABLE playlist_model (
    id SERIAL PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    descripcion TEXT,
    estado_animo estado_animo NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE playlist_cancion (
    playlist_id INTEGER NOT NULL REFERENCES playlist_model(id),
    cancion_id INTEGER NOT NULL REFERENCES cancion_model(id),
    PRIMARY KEY (playlist_id, cancion_id)
);

CREATE VIEW vista_playlist_completa AS
SELECT
    p.id AS playlist_id,
    p.nombre AS playlist_nombre,
    p.descripcion,
    p.estado_animo,
    p.created_at,
    c.id AS cancion_id,
    c.titulo AS cancion_titulo,
    a.nombre AS album_nombre,
    ca.nombre AS cantante_nombre,
    g.nombre AS genero_nombre,
    c.formato,
    c.tiempo_duracion
FROM playlist_model p
JOIN playlist_cancion pc ON p.id = pc.playlist_id
JOIN cancion_model c ON pc.cancion_id = c.id
LEFT JOIN album_model a ON c.album_id = a.id
LEFT JOIN cantante_model ca ON c.cantante_id = ca.id
LEFT JOIN genero_model g ON c.genero_id = g.id;
