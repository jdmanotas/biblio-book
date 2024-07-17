package com.bibliobook.apibook.entity;

import com.bibliobook.apibook.model.PersistentObject;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity(name = "Autor")
@Table(name = "autor",
        indexes = {
                @Index(name = "idx_autor_email", columnList = "email"),
                @Index(name = "idx_autor_identification", columnList = "identification")
        }
)
public class Autor extends PersistentObject implements Serializable {

    @Column(name ="identification", length = 14, nullable = false, unique = true)
    private String identificacion;

    @Column(name ="nombres", length = 32, nullable = false)
    private String nombres;

    @Column(name ="apellidos", length = 32, nullable = false)
    private String apellidos;

    @Column(name ="email", length = 32, nullable = false)
    private String email;

    @OneToMany(mappedBy = "autor", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Libro> libros = new ArrayList<>();

}
