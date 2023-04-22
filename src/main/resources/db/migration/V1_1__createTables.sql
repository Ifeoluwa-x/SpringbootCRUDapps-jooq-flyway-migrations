CREATE TABLE IF NOT EXISTS Todo (
  id SERIAL PRIMARY KEY,
  taskname VARCHAR(50) NOT NULL,
  taskdescription TEXT
);
