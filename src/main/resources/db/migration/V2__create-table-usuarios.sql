CREATE TABLE usuarios (
    id BIGINT AUTO_INCREMENT, 
    nombre VARCHAR(100) NOT NULL UNIQUE,
    email varchar(100) NOT NULL UNIQUE,
    contraseña VARCHAR(300) NOT NULL,   
    PRIMARY KEY (id)
)ENGINE=InnoDB;