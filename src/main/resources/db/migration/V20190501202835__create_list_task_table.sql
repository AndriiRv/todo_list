CREATE TABLE list_task
(
  id               SERIAL PRIMARY KEY,
  headline_of_list VARCHAR(60) NOT NULL,
  date             DATE        NOT NULL
);