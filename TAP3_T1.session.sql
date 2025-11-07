USE tema3_tarea1;

-- DROP TABLE compositores;

-- CREATE TABLE compositores (
--     id_compositor INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
--     foto_compositor longblob,
--     nombre_compositor VARCHAR(255) NOT NULL,
--     epoca ENUM('RENACIMIENTO','BARROCA','CLASICA', 'ROMANTICA', 'CONTEMPORANEA') NOT NULL,
--     num_composiciones INT NOT NULL,
--     vive BOOLEAN DEFAULT(true) NOT NULL
-- );

-- DESC compositores;


SELECT nombre_compositor, epoca, num_composiciones, vive FROM compositores;

-- UPDATE compositores
-- SET
--     foto_compositor = ?,         -- (new BLOB value)
--     nombre_compositor = 'Nuevo Nombre',
--     epoca = 'ROMANTICA',
--     num_composiciones = 25,
--     vive = false
-- WHERE id_objeto = 1;