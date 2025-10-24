package com.generation.blogpessoal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generation.blogpessoal.model.Usuario;
import com.generation.blogpessoal.service.UsuarioService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping("/all")
	public ResponseEntity<List<Usuario>> getAllUsuarios() {
		return ResponseEntity.ok(usuarioService.getAllUsuarios());
	}
	
	 @GetMapping("/{id}")
	    public ResponseEntity<Usuario> getUsuarioById(@PathVariable Long id) {
	        return usuarioService.getById(id)
	                .map(usuario -> ResponseEntity.ok(usuario))
	                .orElse(ResponseEntity.notFound().build());
	    }
	
	 @PostMapping("/cadastrar")
	    public ResponseEntity<Usuario> post(@Valid @RequestBody Usuario usuario) {
	        return usuarioService.cadastrarUsuario(usuario)
	                .map(resposta -> ResponseEntity.status(HttpStatus.CREATED).body(resposta))
	                .orElse(ResponseEntity.badRequest().build());
	    }
}
