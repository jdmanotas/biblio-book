package com.bibliobook.apibook.repository;

import com.bibliobook.apibook.entity.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ILibroRepository extends JpaRepository<Libro, Long> {

    List<Libro> findAllByNombre(String nombre);
    /*
    @Query("SELECT l FROM Libro l LEFT JOIN FETCH l.autor WHERE l.id = :id")
    Libro findByIdWithAutor(@Param("id") Long id);

    @Query("SELECT l FROM Libro l LEFT JOIN FETCH l.autor")
    List<Libro> findAllWithAutores();
    */
}
