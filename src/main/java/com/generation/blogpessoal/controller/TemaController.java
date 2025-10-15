package com.generation.blogpessoal.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.generation.blogpessoal.model.Tema;
import com.generation.blogpessoal.repository.TemaRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/temas")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TemaController {

    @Autowired
    private TemaRepository temaRepository;

    @GetMapping
    public ResponseEntity<List<Tema>> getAll() {
        return ResponseEntity.ok(temaRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tema> getById(@PathVariable Long id) {
        Optional<Tema> tema = temaRepository.findById(id);
        return tema.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/descricao/{descricao}")
    public ResponseEntity<List<Tema>> getByDescricao(@PathVariable String descricao) {
        return ResponseEntity.ok(temaRepository.findAllByDescricaoContainingIgnoreCase(descricao));
    }

    @PostMapping
    public ResponseEntity<Tema> post(@Valid @RequestBody Tema tema) {
        tema.setId(null);
        return ResponseEntity.status(HttpStatus.CREATED).body(temaRepository.save(tema));
    }

    @PutMapping
    public ResponseEntity<Tema> put(@Valid @RequestBody Tema tema) {
        if (tema.getId() == null || !temaRepository.existsById(tema.getId()))
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        return ResponseEntity.ok(temaRepository.save(tema));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (!temaRepository.existsById(id))
            return ResponseEntity.notFound().build();
        temaRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}