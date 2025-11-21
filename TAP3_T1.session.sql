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
    password varchar(36) not null
);

CREATE TABLE records (
    id_record VARCHAR(36) not null primary key,
    id_author VARCHAR(36) not null,
    state_name ENUM('Aguascalientes', 'Baja_California', 'Baja_California_Sur', 'Campeche',
    'Chiapas', 'Chihuahua', 'Ciudad_de_Mexico', 'Coahuila', 
    'Colima', 'Durango', 'Estado_de_Mexico', 'Guanajuato', 
    'Guerrero', 'Hidalgo', 'Jalisco', 'Michoacan',
    'Morelos', 'Nayarit', 'Nuevo_Leon', 'Oaxaca',
    'Puebla', 'Queretaro', 'Quintana_Roo', 'San_Luis_Potosi',
    'Sinaloa', 'Sonora', 'Tabasco', 'Tamaulipas',
    'Tlaxcala', 'Veracruz', 'Yucatan', 'Zacatecas') not  null,
    record_type ENUM( 'TRADICION', 'GASTRONOMIA', 'LUGAR', 'PALABRA') not null,
    title VARCHAR(120) not null,
    description VARCHAR(1200) not null,
    image LONGBLOB,
    is_deleted BOOLEAN NOT NULL,
    is_public BOOLEAN NOT NULL
);

CREATE TABLE requests (
    id_request VARCHAR(36) not null primary key,
    id_record VARCHAR(36) not null,
    id_author VARCHAR(36) not null,
    request_status ENUM( 'WAITING', 'APPROVED', 'REJECTED', 'CANCELED') not null,
    reason VARCHAR(360) not null
);

ALTER TABLE records ADD FOREIGN KEY (id_author) references users(id_user);

ALTER TABLE requests add foreign key (id_record) references records(id_record);

ALTER TABLE requests ADD FOREIGN KEY (id_author) references users(id_user);



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