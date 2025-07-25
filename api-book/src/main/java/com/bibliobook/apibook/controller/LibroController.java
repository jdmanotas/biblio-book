package com.bibliobook.apibook.controller;

import com.bibliobook.apibook.entity.Libro;
import com.bibliobook.apibook.service.ILibroService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class LibroController {

    @Autowired
    private ILibroService libroService;

    @GetMapping("/libros")
    public List<Libro> getAllLibros() {
        return libroService.getAllLibros();
    }

    @PostMapping("/libro")
    public ResponseEntity<Libro> createLibro(@RequestBody Libro Libro) {
        Libro createdLibro = libroService.createLibro(Libro);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdLibro);
    }

    @GetMapping("/libro/{id}")
    public ResponseEntity<Libro> getLibroById(@PathVariable Long id) {
        Optional<Libro> libro = libroService.getLibroId(id);
        return libro.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/libro/{id}")
    public ResponseEntity<Libro> updateLibro(@PathVariable Long id, @RequestBody Libro libro) {
        try {
            Libro updatedLibro = libroService.updateLibro(id, libro);
            return ResponseEntity.ok(updatedLibro);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/libro/{id}")
    public ResponseEntity<Void> deleteLibro(@PathVariable Long id) {
        libroService.deleteLibro(id);
        return ResponseEntity.noContent().build();
    }

}
