DROP TABLE IF EXISTS dispatch;
DROP TABLE IF EXISTS country;

CREATE TABLE country (
    name VARCHAR(255) PRIMARY KEY,
    short_name VARCHAR(16) NOT NULL,
    multiplier FLOAT DEFAULT 1.0 NOT NULL
);

CREATE TABLE dispatch (
  id INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(255) NOT NULL,
  color VARCHAR(15) NOT NULL,
  weight FLOAT NOT NULL,
  destination VARCHAR(255),
  FOREIGN KEY (destination) REFERENCES country(name)
);

INSERT INTO country (name, short_name, multiplier) VALUES
  ('Australia', 'AUS', 7.2),
  ('Brazil', 'BRA', 8.6),
  ('China', 'CHN', 4),
  ('Sweden', 'SWE', 1.3);
