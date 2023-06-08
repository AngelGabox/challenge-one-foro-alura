package com.alura.foro.domain.usuario;

import com.alura.foro.modelo.Usuario;

public record ListadoUsuario(Long id, String nombre, String email, String contraseña ) {

    public ListadoUsuario(Usuario usuario){
        this(usuario.getId(), usuario.getNombre(), usuario.getEmail(), usuario.getContraseña());
    }
}
