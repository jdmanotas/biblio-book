package com.bibliobook.apibook.controller;

import com.bibliobook.apibook.entity.Autor;
import com.bibliobook.apibook.service.IAutorService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class AutorController {

    @Autowired
    private IAutorService autorService;

    @GetMapping("/autores")
    public List<Autor> getAllAutores() {
        return autorService.getAllAutores();
    }

    @PostMapping("/autor")
    public ResponseEntity<Autor> createAutor(@RequestBody Autor autor) {
        Autor createdAutor = autorService.createAutor(autor);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdAutor);
    }

    @GetMapping("/autor/{id}")
    public ResponseEntity<Autor> getAutorById(@PathVariable Long id) {
        Optional<Autor> autor = autorService.getAutorId(id);
        return autor.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/autor/{id}")
    public ResponseEntity<Autor> updateAutor(@PathVariable Long id, @RequestBody Autor autor) {
        try {
            Autor updatedAutor = autorService.updateAutor(id, autor);
            return ResponseEntity.ok(updatedAutor);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/autor/{id}")
    public ResponseEntity<Void> deleteAutor(@PathVariable Long id) {
        autorService.deleteAutor(id);
        return ResponseEntity.noContent().build();
    }

}
