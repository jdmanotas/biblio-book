package com.bibliobook.apibook.service;

import com.bibliobook.apibook.entity.Libro;

import java.util.List;
import java.util.Optional;

public interface ILibroService {

    List<Libro> getAllLibros();
    Libro createLibro(Libro libro);
    Optional<Libro> getLibroId(Long id);
    Libro updateLibro(Long id, Libro libro);
    void deleteLibro(Long id);
}
