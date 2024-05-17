create database lab12;

use lab12;

CREATE TABLE Movie (
    id INT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(255),
    rating FLOAT,
    author VARCHAR(255)
);

INSERT INTO Movie (title, rating, director) VALUES
('2 Fast 2 Furious', 4.5, 'John Singleton'),
('Bean', 3.8, 'Mel Smith');

Select * from Movie;

