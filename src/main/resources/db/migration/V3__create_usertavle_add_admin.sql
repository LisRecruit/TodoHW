CREATE TABLE users (
    id BIGSERIAL PRIMARY KEY,
    username VARCHAR(50) UNIQUE,
    password VARCHAR(255) NOT NULL,
    enabled BOOLEAN NOT NULL
);

CREATE TABLE authorities (
    id BIGSERIAL PRIMARY KEY,
    username VARCHAR(50) UNIQUE,
    role VARCHAR(50) NOT NULL,
    CONSTRAINT fk_authorities_users FOREIGN KEY (username) REFERENCES users(username)
);


INSERT INTO users (username, password, enabled)
VALUES ('user', '$2a$10$2U41FEwStXyIkgEfL25Mt.kDMosMLgtQDplyKy23aBsjH05SOnOo6', true);

INSERT INTO authorities (username, role)
VALUES ('user', 'ROLE_USER');