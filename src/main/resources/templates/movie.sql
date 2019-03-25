DROP TABLE movie;

CREATE TABLE movie(
 movie_id serial PRIMARY KEY,
 title VARCHAR (255) NOT NULL,
 year integer NOT NULL,
 director VARCHAR(255) NOT NULL,
 description VARCHAR (255)
);


INSERT INTO movie(title, year, director, description) VALUES ('Captain Marvel',2019,'Anna Boden','Captain marvel movie');
