-- Insertar roles básicos en el sistema
INSERT INTO roles (role_name)
VALUES ('USER'),
       ('ADMIN') ON CONFLICT (role_name) DO NOTHING;