package com.bibliobook.apibook.service;

import com.bibliobook.apibook.entity.Autor;

import java.util.List;
import java.util.Optional;

public interface IAutorService {

    List<Autor> getAllAutores();
    Autor createAutor(Autor autor);
    Optional<Autor> getAutorId(Long id);
    Autor updateAutor(Long id, Autor autor);
    void deleteAutor(Long id);
}
