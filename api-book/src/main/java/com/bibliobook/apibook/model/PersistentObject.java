package com.bibliobook.apibook.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@MappedSuperclass
public abstract class PersistentObject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name ="code", unique = true)
    private UUID code = UUID.randomUUID();

    @Column(name ="status")
    private Integer status = 1;

    @Column(name ="user_reg", nullable = false)
    private String user_reg = "admin";

    @Column(name ="user_mod", insertable = false)
    private String user_mod;

    @Temporal(value = TemporalType.TIMESTAMP)
    @Column(name = "created_at", updatable = false)
    private LocalDateTime created_at = LocalDateTime.now();

    @Temporal(value = TemporalType.TIMESTAMP)
    @Column(name = "updated_at", insertable = false)
    private LocalDateTime updated_at;

}
