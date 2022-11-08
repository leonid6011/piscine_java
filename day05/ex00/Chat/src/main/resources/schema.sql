CREATE TABLE IF NOT EXISTS users (
    id          SERIAL PRIMARY KEY,
    login       VARCHAR(50) NOT NULL,
    password    VARCHAR(50)
);

CREATE TABLE IF NOT EXISTS rooms (
    id          SERIAL PRIMARY KEY,
    name        TEXT NOT NULL,
    owner_id    INTEGER REFERENCES users(id) NOT NULL
);

CREATE TABLE IF NOT EXISTS messages (
    id          SERIAL PRIMARY KEY,
    author      INTEGER REFERENCES users(id) NOT NULL,
    room        INTEGER REFERENCES rooms(id) NOT NULL,
    text        TEXT NOT NULL,
    timestamp   TIMESTAMP DEFAULT CURRENT_TIMESTAMP
)