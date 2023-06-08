package com.alura.foro.domain.topico;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alura.foro.modelo.Topico;
import org.springframework.stereotype.Repository;

@Repository
public interface TopicoRepository extends JpaRepository<Topico, Long>{
}
