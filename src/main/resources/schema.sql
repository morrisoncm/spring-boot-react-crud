DROP TABLE IF EXISTS client;

CREATE TABLE client (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  code VARCHAR(20) NOT NULL,
  name VARCHAR(100) NOT NULL,
  email VARCHAR(75) NOT NULL
);