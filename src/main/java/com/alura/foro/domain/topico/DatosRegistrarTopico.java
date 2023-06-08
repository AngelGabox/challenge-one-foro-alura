package com.alura.foro.domain.topico;

import java.time.LocalDateTime;

import com.alura.foro.modelo.Curso;
import com.alura.foro.modelo.StatusTopico;
import com.alura.foro.modelo.Usuario;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosRegistrarTopico(

        @NotBlank
        String titulo,
        
        @NotBlank
        String mensaje,
        
        LocalDateTime fechaCreacion,
        
        StatusTopico status,
        
        @NotNull
        Long curso,
        
        @NotNull
        Long autor
) {}
