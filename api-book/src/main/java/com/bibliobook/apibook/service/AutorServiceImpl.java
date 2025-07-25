package com.bibliobook.apibook.service;

import com.bibliobook.apibook.entity.Autor;
import com.bibliobook.apibook.repository.IAutorRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AutorServiceImpl implements IAutorService {

    @Autowired
    private IAutorRepository autorRepository;

    @Override
    public List<Autor> getAllAutores() {
        return autorRepository.findAll();
    }

    @Override
    public Autor createAutor(Autor autor) {
        return autorRepository.save(autor);
    }

    @Override
    public Optional<Autor> getAutorId(Long id) {
        return autorRepository.findById(id);
    }

    @Override
    public Autor updateAutor(Long id, Autor autor) {
        return autorRepository.findById(id)
                .map(updatedAutor -> {
                    updatedAutor.setIdentificacion(autor.getIdentificacion());
                    updatedAutor.setNombres(autor.getNombres());
                    updatedAutor.setApellidos(autor.getApellidos());
                    updatedAutor.setEmail(autor.getEmail());
                    return autorRepository.save(updatedAutor);
                })
                .orElseThrow(() -> new EntityNotFoundException("Autor no fue encontrado para el id: " + id));
    }

    @Override
    public void deleteAutor(Long id) {
        autorRepository.deleteById(id);
    }

}
