package com.bibliobook.apibook.entity;

import com.bibliobook.apibook.model.PersistentObject;
import com.bibliobook.apibook.entity.Autor;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "Libro")
@Table(name = "libro",
        indexes = {
                @Index(name = "idx_libro_nombre", columnList = "nombre"),
                @Index(name = "idx_libro_isbn", columnList = "isbn")
        }
)
public class Libro extends PersistentObject implements Serializable {

    @Column(name ="isbn", length = 18, nullable = false, unique = true)
    private String isbn;

    @Column(name ="nombre", length = 128, nullable = false)
    private String nombre;

    @Column(name ="idautor", nullable = false)
    private Long idautor;
    /*
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idautor", nullable = false)
    @JsonIgnoreProperties("libros")
    private Autor autor;
    */
}
