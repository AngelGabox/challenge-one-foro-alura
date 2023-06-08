package com.alura.foro.controller;

import com.alura.foro.domain.topico.DatosActualizarTopico;
import com.alura.foro.domain.topico.ListadoTopico;
import com.alura.foro.domain.usuario.DatosActualizarUsuario;
import com.alura.foro.domain.usuario.ListadoUsuario;
import com.alura.foro.domain.usuario.UsuarioDetallado;
import com.alura.foro.domain.usuario.UsuarioRepository;
import com.alura.foro.modelo.Topico;
import com.alura.foro.modelo.Usuario;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping(value = "/usuario")
public class UsuarioController {

    private final UsuarioRepository repository;

    public UsuarioController(UsuarioRepository repository){
        this.repository = repository;
    }

    @PostMapping
    public ResponseEntity crear(@RequestBody @Valid Usuario usuario, UriComponentsBuilder uriBuilder){
        repository.save(usuario);
        var uri = uriBuilder.path("/usuario/{id}").buildAndExpand(usuario.getId()).toUri();
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity actualizar(@RequestBody @Valid DatosActualizarUsuario datos){
        Usuario usuario = repository.getReferenceById(datos.id());
        usuario.actualizar(datos);
        return ResponseEntity.ok(new Topico());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity eliminarUsuario(@PathVariable Long id) {
        if (repository.existsById(id)) {
            Usuario usuario = repository.getReferenceById(id);
            repository.delete(usuario);
            return ResponseEntity.ok().body("Usuario borrado exitosamente");
        }
        return ResponseEntity.badRequest().body("Not possible");

    }

    @GetMapping("/{id}")
    public ResponseEntity  usuarioDetallado(@PathVariable Long id){
        Usuario usuario = repository.getReferenceById(id);
        return ResponseEntity.ok(new UsuarioDetallado(usuario));
    }

    @GetMapping
    public ResponseEntity<Page<ListadoUsuario>> listadoUsuarios(@PageableDefault(size = 10, sort = "id") Pageable paginacion) {
        return ResponseEntity.ok(repository.findAll(paginacion).map(ListadoUsuario::new));
    }

}

