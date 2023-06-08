package com.alura.foro.domain.topico;

import java.time.LocalDateTime;

import com.alura.foro.modelo.Curso;
import com.alura.foro.modelo.StatusTopico;
import com.alura.foro.modelo.Topico;
import com.alura.foro.modelo.Usuario;

public record TopicoDetallado(long id, String titulo, String mensaje, LocalDateTime getfechaCreacion, StatusTopico status,
		Usuario autor, Curso curso) {
	
	public TopicoDetallado(Topico topico) {
		this(topico.getId(), topico.getTitulo(), topico.getMensaje(), topico.getfechaCreacion(), topico.getStatus(), topico.getAutor(), topico.getCurso());
	}

}
