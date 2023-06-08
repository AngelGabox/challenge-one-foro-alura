package com.alura.foro.domain.usuario;

import com.alura.foro.modelo.Usuario;
import jakarta.validation.constraints.NotNull;

public record DatosActualizarUsuario(@NotNull Long id, String nombre, String email, String contraseña) {
}
