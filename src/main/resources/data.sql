CREATE TABLE persona (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    origen VARCHAR(255) NOT NULL
);

INSERT INTO persona (id, nombre, origen) VALUES (1, 'Juan Perez', 'MSA');
INSERT INTO persona (id, nombre, origen) VALUES (2, 'Maria Lopez', 'LEGACY');
INSERT INTO persona (id, nombre, origen) VALUES (3, 'Carlos Gomez', 'MSA');