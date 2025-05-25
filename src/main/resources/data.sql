INSERT INTO genero_model(nombre) VALUES 
  ('Pop'), 
  ('Rock'), 
  ('Balada'), 
  ('Latino'), 
  ('Indie');

INSERT INTO cantante_model(nombre, nacionalidad, fecha_nacimiento) VALUES 
  ('Mon Laferte', 'Chilena', '1983-05-02'),
  ('José José', 'Mexicano', '1948-02-17'),
  ('Amanda Miguel', 'Argentina', '1956-06-01'),
  ('Maná', 'Mexicana', '1981-01-01');

INSERT INTO album_model(nombre, anio, cantante_id) VALUES 
  ('La Trenza', 2017, 1),
  ('Romántico', 1984, 2),
  ('El sonido volumen 1', 1985, 3),
  ('Sueños Líquidos', 1997, 4);

INSERT INTO cancion_model(titulo, cantante_id, album_id, tiempo_duracion, formato, genero_id) VALUES 
  ('Amárrame', 1, 1, INTERVAL '3 minutes 30 seconds', 'MP3', 1),
  ('Mi buen amor', 1, 1, INTERVAL '4 minutes 5 seconds', 'FLAC', 1),
  ('El triste', 2, 2, INTERVAL '4 minutes 55 seconds', 'WAV', 3),
  ('Lo pasado, pasado', 2, 2, INTERVAL '3 minutes 30 seconds', 'AAC', 3),
  ('Castillos', 3, 3, INTERVAL '3 minutes 20 seconds', 'MP3', 3),
  ('Él me mintió', 3, 3, INTERVAL '4 minutes 10 seconds', 'MP3', 3),
  ('Clavado en un bar', 4, 4, INTERVAL '4 minutes 5 seconds', 'MP3', 2),
  ('En el muelle de San Blas', 4, 4, INTERVAL '5 minutes 25 seconds', 'FLAC', 2),
  ('Primaveral', 1, 1, INTERVAL '3 minutes 45 seconds', 'MP3', 5),
  ('Tu falta de querer', 1, 1, INTERVAL '4 minutes 35 seconds', 'FLAC', 3),
  ('Gavilán o paloma', 2, 2, INTERVAL '4 minutes 15 seconds', 'WAV', 3),
  ('Vamos a darnos tiempo', 2, 2, INTERVAL '4 minutes 0 seconds', 'MP3', 3),
  ('Como un títere', 3, 3, INTERVAL '3 minutes 40 seconds', 'AAC', 3),
  ('Hagamos un trato', 3, 3, INTERVAL '4 minutes 0 seconds', 'FLAC', 3),
  ('Hechicera', 4, 4, INTERVAL '4 minutes 45 seconds', 'MP3', 2),
  ('Ángel de amor', 4, 4, INTERVAL '5 minutes 0 seconds', 'WAV', 2);

INSERT INTO playlist_model(nombre, descripcion, estado_animo, created_at) VALUES 
  ('Relax total', 'Canciones suaves para descansar', 'RELAJADO', CURRENT_TIMESTAMP),
  ('Sube el ánimo', 'Para motivarte al 100%', 'ENERGICO', CURRENT_TIMESTAMP),
  ('Románticas', 'Amor y nostalgia', 'MELANCOLICO', CURRENT_TIMESTAMP);

INSERT INTO playlist_cancion(playlist_id, cancion_id) VALUES 
  (1, 3),   -- El triste
  (1, 6),   -- Él me mintió
  (1, 8),   -- En el muelle de San Blas
  (1, 12),  -- Vamos a darnos tiempo

  (2, 1),   -- Amárrame
  (2, 5),   -- Castillos
  (2, 7),   -- Clavado en un bar
  (2, 15),  -- Hechicera

  (3, 2),   -- Mi buen amor
  (3, 4),   -- Lo pasado, pasado
  (3, 10),  -- Tu falta de querer
  (3, 11),  -- Gavilán o paloma
  (3, 14);  -- Hagamos un trato
