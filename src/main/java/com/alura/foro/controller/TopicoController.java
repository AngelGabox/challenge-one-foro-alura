package com.alura.foro.controller;

import java.net.URI;

import com.alura.foro.domain.topico.*;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import com.alura.foro.modelo.Topico;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/topicos")
public class TopicoController {
	
//	@Autowired
	private final TopicoRepository topicoRepository;

	public TopicoController(TopicoRepository repository) {
		this.topicoRepository = repository;
	}

	@PostMapping
    public ResponseEntity registrar(@RequestBody @Valid DatosRegistrarTopico datos, UriComponentsBuilder uriBuilder) {

		Topico topico = new Topico(datos);
        topicoRepository.save(topico);

        var uri = uriBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();

        return ResponseEntity.created((URI) uri).body(new TopicoDetallado(topico));
	}


    @GetMapping
    public ResponseEntity<Page<ListadoTopico>> listadoTopico(@PageableDefault(size = 10, sort = "id") Pageable paginacion) {
        return ResponseEntity.ok(topicoRepository.findAll(paginacion).map(ListadoTopico::new));
    }

    @GetMapping("/{id}")
    public ResponseEntity topicoDetallado(@PathVariable Long id) {
        var topico = topicoRepository.getReferenceById(id);
        return ResponseEntity.ok(new TopicoDetallado(topico));
    }

    @PutMapping
    public ResponseEntity actualizar(@RequestBody @Valid DatosActualizarTopico datos){
        Topico topico = topicoRepository.getReferenceById(datos.id());
        topico.actualizar(datos);
        return ResponseEntity.ok(new Topico());
    }

    @DeleteMapping("/{id}")
//    @Transactional
    public ResponseEntity eliminarTopico(@PathVariable Long id) {
        if (topicoRepository.existsById(id)) {
            Topico topico = topicoRepository.getReferenceById(id);
            topicoRepository.delete(topico);
            return ResponseEntity.ok().body("Ok delete");
        }
        return ResponseEntity.badRequest().body("Not possible");

    }

}
