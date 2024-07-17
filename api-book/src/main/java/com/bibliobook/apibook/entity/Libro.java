package com.bibliobook.apibook.entity;

import com.bibliobook.apibook.model.PersistentObject;
import com.bibliobook.apibook.entity.Autor;
import com.fasterxml.jackson.annotation.JsonBackReference;
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

    /*
    @ManyToOne
    @JoinColumn(name = "idautor", referencedColumnName = "id", nullable = false, insertable = false, updatable = false) // Clave foránea que referencia a la tabla 'autor'
    private Autor autor;
    */

    @ManyToOne
    @JoinColumn(name = "idautor", nullable = false, insertable = false, updatable = false) // Clave foránea que referencia a la tabla 'autor'
    @JsonBackReference
    private Autor autor;

}
