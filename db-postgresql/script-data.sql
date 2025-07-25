INSERT INTO public.autor (identification, nombres, apellidos, email, user_reg)
VALUES
    ('ID001', 'Juan', 'Pérez', 'juan.perez@gmail.com', 'admin'),
    ('ID002', 'María', 'González', 'maria.gonzalez@hotmail.com', 'admin'),
    ('ID003', 'Carlos', 'López', 'carlos.lopez@outlook.com', 'admin'),
    ('ID004', 'Ana', 'Martínez', 'ana.martinez@gmail.com', 'admin'),
    ('ID005', 'Pedro', 'García', 'pedro.garcia@yahoo.com', 'admin'),
    ('ID006', 'Laura', 'Díaz', 'laura.diaz@hotmail.com', 'admin'),
    ('ID007', 'Luis', 'Rodríguez', 'luis.rodriguez@gmail.com', 'admin'),
    ('ID008', 'Elena', 'Hernández', 'elena.hernandez@outlook.com', 'admin'),
    ('ID009', 'Javier', 'Sánchez', 'javier.sanchez@gmail.com', 'admin'),
    ('ID010', 'Sofía', 'Ramírez', 'sofia.ramirez@yahoo.com', 'admin');

INSERT INTO public.libro (idautor, isbn, nombre, user_reg)
VALUES
    (1, '978-3-16-148410-0', 'Introducción a SQL', 'admin'),
    (2, '978-1-4028-9462-6', 'La Odisea', 'admin'),
    (3, '978-0-06-112241-5', 'Cien años de soledad', 'admin'),
    (4, '978-0-316-00034-5', 'Harry Potter y la piedra filosofal', 'admin'),
    (5, '978-3-16-148411-0', 'Satanas', 'admin'),
    (6, '978-1-56619-909-4', 'La parabola', 'admin'),
    (7, '978-0-7432-6003-1', 'To Kill a Mockingbird', 'admin'),
    (8, '978-0-8129-7762-7', '1984', 'admin'),
    (9, '978-0-06-231500-7', 'The Great Gatsby', 'admin'),
    (10, '978-0-7432-8956-2', 'Pride and Prejudice', 'admin');
