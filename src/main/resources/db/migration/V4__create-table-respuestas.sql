CREATE TABLE respuestas (
    id BIGINT AUTO_INCREMENT,   
    mensaje VARCHAR(300) NOT NULL,
    fecha_creacion DATETIME NOT NULL,
    solucion BOOLEAN NOT NULL, 
    topico_id BIGINT NOT NULL,
    autor_id BIGINT NOT NULL, 
    PRIMARY KEY (id),
    FOREIGN KEY(topico_id) REFERENCES topicos(id) ON DELETE CASCADE,
    FOREIGN KEY(autor_id) REFERENCES usuarios(id) ON DELETE CASCADE
)ENGINE=InnoDB;