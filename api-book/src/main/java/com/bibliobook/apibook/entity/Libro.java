package com.bibliobook.apibook.entity;

import com.bibliobook.apibook.model.PersistentObject;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
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

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idautor")
    private Autor autor;

}
