CREATE TABLE list_task
(
  id               SERIAL PRIMARY KEY,
  headline_of_list VARCHAR(60) NOT NULL,
  date             DATE        NOT NULL
);
CREATE TABLE task
(
  id       SERIAL PRIMARY KEY,
  id_list  INTEGER REFERENCES list_task (id) ON DELETE CASCADE,
  headline VARCHAR(30) NOT NULL,
  title    VARCHAR(60) NOT NULL,
  date     DATE        NOT NULL,
  done     BOOLEAN
);