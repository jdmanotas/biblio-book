package com.bibliobook.apibook.service;

import com.bibliobook.apibook.entity.Autor;
import com.bibliobook.apibook.entity.Libro;
import com.bibliobook.apibook.repository.IAutorRepository;
import com.bibliobook.apibook.repository.ILibroRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibroServiceImpl implements ILibroService{

    @Autowired
    private ILibroRepository libroRepository;

    //@Autowired
    //private IAutorRepository autorRepository;

    @Override
    public List<Libro> getAllLibros() {
        return libroRepository.findAll();
        //return libroRepository.findAllWithAutores();
    }

    @Override
    public Libro createLibro(Libro libro) {
        return libroRepository.save(libro);
    }

    @Override
    public Optional<Libro> getLibroId(Long id) {
        return libroRepository.findById(id);
    }

    @Override
    public Libro updateLibro(Long id, Libro libro) {
        //Optional<Autor> autor = autorRepository.findById(libro.getAutor().getId());
        return libroRepository.findById(id)
                .map(updatedlibro -> {
                    updatedlibro.setIsbn(libro.getIsbn());
                    updatedlibro.setNombre(libro.getNombre());
                    return libroRepository.save(updatedlibro);
                })
                .orElseThrow(() -> new EntityNotFoundException("libro no fue encontrado para el id: " + id));
    }

    @Override
    public void deleteLibro(Long id) {
        libroRepository.deleteById(id);
    }
}
