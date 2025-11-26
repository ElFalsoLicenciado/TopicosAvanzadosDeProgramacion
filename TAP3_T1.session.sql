use tap_p3_agodic25;

ALTER TABLE proveedores ADD is_hidden BOOLEAN NOT NULL DEFAULT 0;

CREATE TABLE productos (
    id_producto varchar(36) NOT NULL,
    numero_producto INT NOT NULL,  
    id_categoria varchar(36) NOT NULL,
    id_proveedor varchar(36) DEFAULT NULL,
    nombre_producto varchar(120) NOT NULL,
    precio double NOT NULL DEFAULT 0,
    cantidad int(11) NOT NULL DEFAULT 0,
    foto_producto longtext DEFAULT NULL,
    nombre_foto_producto varchar(120) DEFAULT NULL,
    is_hidden tinyint(1) NOT NULL DEFAULT 0,
    
    PRIMARY KEY (id_producto, numero_producto),

    FOREIGN KEY (id_categoria) REFERENCES categorias(id_categoria),
    FOREIGN KEY (id_proveedor) REFERENCES proveedores(id_proveedor)
);

CREATE TABLE ventas (
    id_venta VARCHAR(36) NOT NULL,
    numero INT NOT NULL,
    id_usuario VARCHAR(36) NOT NULL,
    fecha TIMESTAMP NOT NULL,
    total DECIMAL(10,2) NOT NULL,

    PRIMARY KEY(id_venta),

    FOREIGN KEY (id_usuario) REFERENCES usuarios(id_usuario)
);

UPDATE productos SET cantidad = 60 WHERE id_producto = '4abbe1a2-ca9f-4cae-8eb3-6cb4800127d' AND numero_producto = 1;

CREATE TABLE detalles_venta (
    id_detalle VARCHAR(36) NOT NULL PRIMARY KEY,
    id_venta VARCHAR(36) NOT NULL,
    numero INT NOT NULL,
    id_producto VARCHAR(36) NOT NULL,
    numero_producto INT NOT NULL,
    cantidad INT NOT NULL,
    precio_unitario DECIMAL(10,2) NOT NULL,
    subtotal DECIMAL(10,2) NOT NULL,

    FOREIGN KEY (id_venta) REFERENCES ventas(id_venta),
    FOREIGN KEY (id_producto, numero_producto) REFERENCES productos(id_producto, numero_producto)
);



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