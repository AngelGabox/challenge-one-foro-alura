package com.alura.foro.domain.usuario;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alura.foro.modelo.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
}
