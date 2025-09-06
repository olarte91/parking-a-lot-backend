-- Tabla roles
CREATE TABLE IF NOT EXISTS roles
(
    id         UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    role_name  VARCHAR(50) UNIQUE NOT NULL,
    created_at TIMESTAMP        DEFAULT CURRENT_TIMESTAMP
);

-- Tabla users
CREATE TABLE IF NOT EXISTS app_users
(
    id                    UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    user_name             VARCHAR(50) UNIQUE  NOT NULL,
    password              VARCHAR(255)        NOT NULL,
    email                 VARCHAR(100) UNIQUE NOT NULL,
    is_enabled            BOOLEAN          DEFAULT true,
    created_at            TIMESTAMP        DEFAULT CURRENT_TIMESTAMP,
    account_no_expired    BOOLEAN          DEFAULT true,
    account_no_locked     BOOLEAN          DEFAULT true,
    credential_no_expired BOOLEAN          DEFAULT true
);

-- Tabla intermedia user_roles
CREATE TABLE IF NOT EXISTS user_roles
(
    user_id UUID REFERENCES app_users (id) ON DELETE CASCADE,
    role_id UUID REFERENCES roles (id) ON DELETE CASCADE,
    PRIMARY KEY (user_id, role_id)
);