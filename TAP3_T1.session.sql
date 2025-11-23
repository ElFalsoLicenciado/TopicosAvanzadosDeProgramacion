use tap_p3_agodic25;

-- desc categorias;

-- desc productos;

-- desc proveedores;

-- desc usuarios;

-- CREATE DATABASE proyecto_t3;

CREATE TABLE users (
    id_user varchar(36) not null primary key,
    user_type ENUM('USER','ADMIN', 'GUEST') not null,
    username varchar(36) not null,
    password varchar(64) not null
);

CREATE TABLE records (
    id_record VARCHAR(36) not null,                                             
    record_number INT not null,                                                             -- 1
    id_author VARCHAR(36) not null,                                                         -- 2
    state_name ENUM('Aguascalientes', 'Baja_California', 'Baja_California_Sur', 'Campeche',
    'Chiapas', 'Chihuahua', 'Ciudad_de_Mexico', 'Coahuila', 
    'Colima', 'Durango', 'Estado_de_Mexico', 'Guanajuato', 
    'Guerrero', 'Hidalgo', 'Jalisco', 'Michoacan',
    'Morelos', 'Nayarit', 'Nuevo_Leon', 'Oaxaca',
    'Puebla', 'Queretaro', 'Quintana_Roo', 'San_Luis_Potosi',
    'Sinaloa', 'Sonora', 'Tabasco', 'Tamaulipas',
    'Tlaxcala', 'Veracruz', 'Yucatan', 'Zacatecas') not  null,                              -- 3
    record_type ENUM( 'TRADICION', 'GASTRONOMIA', 'LUGAR', 'PALABRA') not null,             -- 4
    title VARCHAR(120) not null,                                                            -- 5
    description VARCHAR(1200) not null,                                                     -- 6
    image LONGTEXT,                                                                         -- 7
    image_name VARCHAR(120),                                                                -- 8
    is_hidden BOOLEAN NOT NULL,                                                             -- 9
    is_public BOOLEAN NOT NULL,                                                              -- 10
    primary key (id_record, record_number)
);

SELECT id_record, record_number, id_author, state_name, record_type, title, description FROM records;

SELECT s.state_name,
       COUNT(r.state_name) AS total_records
FROM (
    SELECT 'Aguascalientes' AS state_name UNION ALL
    SELECT 'Baja_California' UNION ALL
    SELECT 'Baja_California_Sur' UNION ALL
    SELECT 'Campeche' UNION ALL
    SELECT 'Chiapas' UNION ALL
    SELECT 'Chihuahua' UNION ALL
    SELECT 'Ciudad_de_Mexico' UNION ALL
    SELECT 'Coahuila' UNION ALL
    SELECT 'Colima' UNION ALL
    SELECT 'Durango' UNION ALL
    SELECT 'Estado_de_Mexico' UNION ALL
    SELECT 'Guanajuato' UNION ALL
    SELECT 'Guerrero' UNION ALL
    SELECT 'Hidalgo' UNION ALL
    SELECT 'Jalisco' UNION ALL
    SELECT 'Michoacan' UNION ALL
    SELECT 'Morelos' UNION ALL
    SELECT 'Nayarit' UNION ALL
    SELECT 'Nuevo_Leon' UNION ALL
    SELECT 'Oaxaca' UNION ALL
    SELECT 'Puebla' UNION ALL
    SELECT 'Queretaro' UNION ALL
    SELECT 'Quintana_Roo' UNION ALL
    SELECT 'San_Luis_Potosi' UNION ALL
    SELECT 'Sinaloa' UNION ALL
    SELECT 'Sonora' UNION ALL
    SELECT 'Tabasco' UNION ALL
    SELECT 'Tamaulipas' UNION ALL
    SELECT 'Tlaxcala' UNION ALL
    SELECT 'Veracruz' UNION ALL
    SELECT 'Yucatan' UNION ALL
    SELECT 'Zacatecas'
) AS s
LEFT JOIN records r
    ON r.state_name = s.state_name
GROUP BY s.state_name
ORDER BY s.state_name;


CREATE TABLE requests (
    id_request VARCHAR(36) not null primary key,
    id_record VARCHAR(36) not null,
    record_number INT not null,
    id_author VARCHAR(36) not null,
    request_status ENUM( 'WAITING', 'APPROVED', 'REJECTED', 'CANCELED') not null,
    reason VARCHAR(360) not null
);

ALTER TABLE records ADD FOREIGN KEY (id_author) references users(id_user);

ALTER TABLE requests add foreign key (id_record, record_number) references records(id_record, record_number);

ALTER TABLE requests ADD FOREIGN KEY (id_author) references users(id_user);

INSERT INTO users VALUES (
    UUID(),'USER', 'memo', 'a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3'
);

INSERT INTO records VALUES (UUID(), 1, '5e042d16-c6a9-11f0-a9fd-e88088c48b50', 'Aguascalientes', 'TRADICION', 'Prueba4', 'Wevos',null, null ,'0', '1'),
    (UUID(), 1, '5e042d16-c6a9-11f0-a9fd-e88088c48b50', 'Aguascalientes', 'GASTRONOMIA', 'Prueba5', 'Wevos',null, null ,'0', '1'),
    (UUID(), 1, '5e042d16-c6a9-11f0-a9fd-e88088c48b50', 'Aguascalientes', 'LUGAR', 'Prueba6', 'Wevos',null, null ,'0', '1')
    -- (UUID(), 1, '5e042d16-c6a9-11f0-a9fd-e88088c48b50', 'Aguascalientes', 'PALABRA', 'Prueba1', 'Wevos',null, null ,'0', '1'),
    -- (UUID(), 1, '5e042d16-c6a9-11f0-a9fd-e88088c48b50', 'Coahuila', 'GASTRONOMIA', 'Prueba2', 'Wevos',null, null ,'0', '1'),
    -- (UUID(), 1, '5e042d16-c6a9-11f0-a9fd-e88088c48b50', 'Campeche', 'LUGAR', 'Prueba3', 'Wevos',null, null ,'0', '1');
;

    SELECT * FROM records GROUP BY record_type ORDER BY state_name;


-- USE tema3_tarea1;

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


-- SELECT nombre_compositor, epoca, num_composiciones, vive FROM compositores;

-- UPDATE compositores
-- SET
--     foto_compositor = ?,         -- (new BLOB value)
--     nombre_compositor = 'Nuevo Nombre',
--     epoca = 'ROMANTICA',
--     num_composiciones = 25,
--     vive = false
-- WHERE id_objeto = 1;