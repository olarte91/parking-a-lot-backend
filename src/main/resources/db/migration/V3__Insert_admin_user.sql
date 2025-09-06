-- Insertar usuario administrador por defecto (solo desarrollo)
-- Contraseña: Admin123@ (hasheada con BCrypt)
INSERT INTO app_users (user_name, password, email, is_enabled, account_no_expired, account_no_locked,
                      credential_no_expired)
VALUES ('admin', '$2a$10$N.zmdr9k7uOCQb376NoUnuTJ8iYqiSfFGpRx9fYKCU6lU4Bg8ArHa', 'admin@app.com', true, true, true,
        true)
ON CONFLICT (user_name) DO NOTHING;

-- Asignar rol ADMIN al usuario admin
INSERT INTO user_roles (user_id, role_id)
SELECT (SELECT id FROM app_users WHERE user_name = 'admin'),
       (SELECT id FROM roles WHERE role_name = 'ADMIN')
ON CONFLICT DO NOTHING;