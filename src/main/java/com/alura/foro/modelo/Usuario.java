package com.alura.foro.modelo;

import com.alura.foro.domain.usuario.DatosActualizarUsuario;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@Entity(name = "Usuario")
@Table(name = "usuarios")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotBlank
	private String nombre;
	
	@NotBlank
	@Email
	private String email;
	
	@NotBlank
	private String contraseña;

	public Usuario(Long id){
		this.id = id;
	}

	public Usuario(Long id, String nombre, String email, String contraseña){
		this.id = id;
		this.nombre = nombre;
		this.email = email;
		this.contraseña = contraseña;
	}

//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + ((id == null) ? 0 : id.hashCode());
//		return result;
//	}

//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Usuario other = (Usuario) obj;
//		if (id == null) {
//			if (other.id != null)
//				return false;
//		} else if (!id.equals(other.id))
//			return false;
//		return true;
//	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContrasena() {
		return contraseña;
	}

	public void setContrasena(String contrasena) {
		this.contraseña = contrasena;
	}

	public void actualizar(DatosActualizarUsuario datos) {
		this.nombre = datos.nombre();
		this.email = datos.email();
		this.contraseña = datos.contraseña();
	}
}
