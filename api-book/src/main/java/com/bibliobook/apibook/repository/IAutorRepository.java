package com.bibliobook.apibook.repository;

import com.bibliobook.apibook.entity.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IAutorRepository extends JpaRepository<Autor, Long> {

    List<Autor> findAllByNombres(String nombres);
    List<Autor> findAllByApellidos(String apellidos);

}
