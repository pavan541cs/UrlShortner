CREATE TABLE users (
  id SERIAL PRIMARY KEY,
  name VARCHAR(255) NOT NULL,
  email VARCHAR(255) NOT NULL,
  creation_date DATE NOT NULL
);

CREATE TABLE short_link (
  id SERIAL PRIMARY KEY,
  user_id INTEGER REFERENCES USERS(id),
--  FOREIGN KEY(user) REFERENCES USERS(id),
  original_url VARCHAR(255) NOT NULL,
  short_url VARCHAR(255) NOT NULL
);