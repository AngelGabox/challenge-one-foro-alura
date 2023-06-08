package com.alura.foro.domain.usuario;

import com.alura.foro.modelo.Usuario;
import jakarta.validation.constraints.NotNull;

public record UsuarioDetallado(@NotNull Long id, String nombre, String email, String contraseña) {

    public UsuarioDetallado(Usuario usuario){
        this(usuario.getId(), usuario.getNombre(), usuario.getEmail(), usuario.getContraseña());
    }
}
