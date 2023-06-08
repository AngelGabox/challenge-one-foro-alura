package com.alura.foro.modelo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.alura.foro.domain.topico.DatosActualizarTopico;
import org.springframework.data.annotation.CreatedDate;

import com.alura.foro.domain.topico.DatosRegistrarTopico;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name="topicos")
@Entity(name="Topico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of="id")
public class Topico {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotBlank
	private String titulo;
	
	@NotBlank
	private String mensaje;
	
	@CreatedDate
//	@Column(name = "fecha_creacion")
	private LocalDateTime fechaCreacion = LocalDateTime.now();
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private StatusTopico status = StatusTopico.NO_RESPONDIDO;
	
	@NotNull
	@ManyToOne
	private Usuario autor;
	
	@NotNull
	@ManyToOne
	private Curso curso;

	@OneToMany
	private List<Respuesta> respuestas = new ArrayList<>();

	public Topico(long id, String titulo, String mensaje, LocalDateTime fechaDeCreacion, StatusTopico status, Usuario autor, Curso curso) {
		this.id = id;
		this.titulo = titulo;
		this.mensaje = mensaje;
		this.autor = autor;
		this.curso = curso;
	}

	public Topico(DatosRegistrarTopico datos) {
		this.titulo = datos.titulo();
		this.mensaje = datos.mensaje();
		this.status = datos.status();
		this.autor = new Usuario(datos.autor());
		this.curso = new Curso(datos.curso());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
//		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	public void actualizar(DatosActualizarTopico datos) {
		this.titulo = datos.titulo();
		this.mensaje = datos.mensaje();
//		this.fechaCreacion = datos.fechaCreacion();
		this.status = datos.status();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Topico other = (Topico) obj;
//		if (this.id == null) {
//			if (other.id != null)
//				return false;
//		} else if (!id.equals(other.id))
//			return false;
		return false;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public LocalDateTime getfechaCreacion() {
		return fechaCreacion;
	}

	public void setfechaCreacion(LocalDateTime fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public StatusTopico getStatus() {
		return status;
	}

	public void setStatus(StatusTopico status) {
		this.status = status;
	}

	public Usuario getAutor() {
		return autor;
	}

	public void setAutor(Usuario autor) {
		this.autor = autor;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public List<Respuesta> getRespuestas() {
		return respuestas;
	}

	public void setRespuestas(List<Respuesta> respuestas) {
		this.respuestas = respuestas;
	}
}
