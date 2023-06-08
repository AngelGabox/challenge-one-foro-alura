package com.alura.foro.domain.curso;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alura.foro.modelo.Curso;


public interface CursoRepository extends JpaRepository<Curso, Long> {
    Curso findByNombre(String curso);
}
