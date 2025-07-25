/*
 * Script Aplicacion de Libros y Autores
 * */
create extension "uuid-ossp"; 
/*
 * Crear tabla de Autores
 * */
CREATE TABLE public.autor (
	id bigserial primary key,
	code uuid NULL DEFAULT uuid_generate_v4(),
	
	identification varchar(14) NOT NULL,
	nombres varchar(32) NOT null,
	apellidos varchar(32) NOT null,
	email varchar(42) NOT NULL,
	
	status int4 NULL DEFAULT 1,
	user_reg varchar(12) NOT NULL,
	user_mod varchar(12) NULL,
	created_at timestamp NULL DEFAULT CURRENT_TIMESTAMP,
	updated_at timestamp NULL,
	
	CONSTRAINT autor_identification_unique UNIQUE (identification),
	CONSTRAINT autor_email_unique UNIQUE (email)
);

CREATE INDEX idx_autor_email ON public.autor USING btree (email);
CREATE INDEX idx_autor_identification ON public.autor USING btree (identification);


/*
 * Crear tabla de libros
 * */
CREATE TABLE public.libro (
	id bigserial primary key,
	code uuid NULL DEFAULT uuid_generate_v4(),
	
	idautor bigint NOT NULL,
	isbn varchar(18) NOT NULL,
	nombre varchar(32) NOT null,
	
	status int4 NULL DEFAULT 1,
	user_reg varchar(12) NOT NULL,
	user_mod varchar(12) NULL,
	created_at timestamp NULL DEFAULT CURRENT_TIMESTAMP,
	updated_at timestamp NULL,
	
	CONSTRAINT libro_isdn_unique UNIQUE (isbn),
	CONSTRAINT fk_idautor FOREIGN KEY (idautor) REFERENCES autor(id)
);

CREATE INDEX idx_libro_nombre ON public.libro USING btree (nombre);
CREATE INDEX idx_libro_isbn ON public.libro USING btree (isbn);
