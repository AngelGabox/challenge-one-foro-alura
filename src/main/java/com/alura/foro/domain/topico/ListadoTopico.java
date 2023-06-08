package com.alura.foro.domain.topico;

import com.alura.foro.modelo.Topico;
import com.alura.foro.modelo.Usuario;

import java.time.LocalDateTime;

public record ListadoTopico(Long id, String titulo, String mensaje, LocalDateTime fechaCreacion, Usuario autor) {

    public ListadoTopico(Topico topico){
        this(topico.getId(),
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getfechaCreacion(),
                topico.getAutor());
    }
}
