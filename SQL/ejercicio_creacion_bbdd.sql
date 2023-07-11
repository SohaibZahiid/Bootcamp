DROP DATABASE IF EXISTS db_movies;
CREATE DATABASE IF NOT EXISTS db_movies;
USE db_movies;

CREATE TABLE IF NOT EXISTS movies (
	id INT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(100),
    year INT,
    image_url VARCHAR(255),
    certificate VARCHAR(45),
    runtime INT,
    imdb_rating FLOAT,
    description TEXT,
    metascore INT,
    votes int,
    gross int
);

CREATE TABLE IF NOT EXISTS directors (
	id INT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(45) UNIQUE,
    about TEXT
);

CREATE TABLE IF NOT EXISTS movies_directors (
	movies_id INT UNSIGNED NOT NULL,
    directors_id INT UNSIGNED NOT NULL,
    FOREIGN KEY (movies_id) REFERENCES movies(id),
    FOREIGN KEY (directors_id) REFERENCES directors(id)
);

CREATE TABLE IF NOT EXISTS stars (
	id INT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(45),
    about TEXT
);

CREATE TABLE IF NOT EXISTS movies_stars (
	movies_id INT UNSIGNED NOT NULL,
    stars_id INT UNSIGNED NOT NULL,
    FOREIGN KEY (movies_id) REFERENCES movies(id),
    FOREIGN KEY (stars_id) REFERENCES stars(id)
);

CREATE TABLE IF NOT EXISTS genres (
	id INT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(45)
);

CREATE TABLE IF NOT EXISTS movies_genres (
	movies_id INT UNSIGNED NOT NULL,
    genres_id INT UNSIGNED NOT NULL,
    FOREIGN KEY (movies_id) REFERENCES movies(id),
    FOREIGN KEY (genres_id) REFERENCES genres(id)
);

INSERT INTO movies (title, year, image_url, certificate, runtime, imdb_rating, description, metascore, votes, gross)
VALUES 
('John Wick: Chapter 4', 2023, 'https://m.media-amazon.com/images/M/MV5BMDExZGMyOTMtMDgyYi00NGIwLWJhMTEtOTdkZGFjNmZiMTEwXkEyXkFqcGdeQXVyMjM4NTM5NDY@._V1_FMjpg_UY6001_.jpg', 'R', 169, 7.9, 'John Wick uncovers a path to defeating The High Table. But before he can earn his freedom, Wick must face off against a new enemy with powerful alliances across the globe and forces that turn old friends into foes.', 78, 1300, 427125680),
('Django Unchained', 2012, 'https://m.media-amazon.com/images/M/MV5BMjIyNTQ5NjQ1OV5BMl5BanBnXkFtZTcwODg1MDU4OA@@._V1_FMjpg_UY2048_.jpg', 'R', 165, 8.4, 'With the help of a German bounty-hunter, a freed slave sets out to rescue his wife from a brutal plantation owner in Mississippi.', 81, 1800, 426074373),
('21 Jump Street', 2012, 'https://m.media-amazon.com/images/M/MV5BNGVhMTQxZTAtNTRiMi00YmRkLWExNTEtZmEzYzRhM2IwNmE1XkEyXkFqcGdeQXVyNDk3NzU2MTQ@._V1_FMjpg_UX1013_.jpg', 'R', 109, 7.2, 'A pair of underachieving cops are sent back to a local high school to blend in and bring down a synthetic drug ring.', 69, 460, 201585328),
('The Shawshank Redemption', 1994, 'https://m.media-amazon.com/images/M/MV5BMzBmNWM0YzktOTM2MC00MzVkLWFiNjUtNWVjMWRiOTQ0OWM0XkEyXkFqcGdeQXVyNjAwNDUxODI@._V1_FMjpg_UY3000_.jpg', 'R', 142, 9.3, 'Over the course of several years, two convicts form a friendship, seeking consolation and, eventually, redemption through basic compassion.', 82, 10000, 28884716),
('Inception', 2010, 'https://m.media-amazon.com/images/M/MV5BMTMyMzYxMDQ3NV5BMl5BanBnXkFtZTcwNTA1NTcwMw@@._V1_FMjpg_UX300_.jpg', 'PG-13', 148, 8.8, "A thief who steals corporate secrets through the use of dream-sharing technology is given the inverse task of planting an idea into the mind of a C.E.O., but his tragic past may doom the project and his team to disaster.", 74, 4700, 870792649);

INSERT INTO directors (name, about)
VALUES 
('Chad Stahelski', 'He came from a kick-boxing background; he entered the film field as a stunt performer at the age of 24. Before that, he worked as an instructor at the Inosanto Martial Arts Academy in California, teaching Jeet Kune Do/Jun Fan. After doing numerous roles in low budget martial art movies like Mission of Justice (1992) and Bloodsport III (1996) his first start as a stunt double came from the movie The Crow (1994) for doubling late Brandon Lee whom he trained with at the Inosanto Academy.'),
('Quentin Tarantino', "Quentin Jerome Tarantino was born in Knoxville, Tennessee. His father, Tony Tarantino, is an Italian-American actor and musician from New York, and his mother, Connie (McHugh), is a nurse from Tennessee. Quentin moved with his mother to Torrance, California, when he was four years old.In January of 1992, first-time writer-director Tarantino's Reservoir Dogs (1992) appeared at the Sundance Film Festival. The film garnered critical acclaim and the director became a legend immediately."),
('Phil Lord', 'Philip A. Lord is an American filmmaker, producer and writer who collaborates with Christopher Miller. They both worked on Clone High, a cult classic animated sci-fi teen comedy show, The Lego Movie, 21 Jump Street, 22 Jump Street and Spider-Man: Into the Spider-Verse. Into the Spider-Verse is considered one of the best animated films of the 2010s and won Best Animated Feature.'),
('Frank Darabont', "Three-time Oscar nominee Frank Darabont was born in a refugee camp in 1959 in Montbeliard, France, the son of Hungarian parents who had fled Budapest during the failed 1956 Hungarian revolution. Brought to America as an infant, he settled with his family in Los Angeles and attended Hollywood High School. His first job in movies was as a production assistant on the 1981 low-budget film, Hell Night (1981), starring Linda Blair."),
('Christopher Nolan', "Best known for his cerebral, often nonlinear, storytelling, acclaimed writer-director Christopher Nolan was born on July 30, 1970, in London, England. Over the course of 15 years of filmmaking, Nolan has gone from low-budget independent films to working on some of the biggest blockbusters ever made.At 7 years old, Nolan began making short movies with his father's Super-8 camera.");



INSERT INTO movies_directors (movies_id, directors_id)
VALUES 
(1, 1),
(2, 2),
(3, 3),
(4, 4),
(5, 5);

INSERT INTO stars (name, about)
VALUES 
('Keanu Reeves', "Keanu Charles Reeves, whose first name means cool breeze over the mountains in Hawaiian, was born September 2, 1964 in Beirut, Lebanon. He is the son of Patricia Taylor, a showgirl and costume designer, and Samuel Nowlin Reeves, a geologist. Keanu's father was born in Hawaii, of British, Portuguese, Native Hawaiian, and Chinese ancestry, and Keanu's mother is originally from England."),
('Laurence Fishburne', "Critically hailed for his forceful, militant, authoritative figures and one of Hollywood's most talented and versatile performers, Laurence (John) Fishburne III has been the recipient of numerous awards, including a number of NAACP Image honors.Born in Augusta, Georgia on July 30, 1961, to Hattie Bell (Crawford), a teacher, and Laurence John Fishburne, Jr., a juvenile corrections officer."),
('George Georgiou', "George trained at the prestigious Drama Centre London under Christopher Fettes and Yat Malgram. His career started on the London stage in plays at the National Theatre, Theatre Royal S.E, Haymarket Theatre and numerous off West End productions. He played the leading role in a new play 'Chicken' by Mike Batistick at the Trafalgar Studios in the heart of London's West End."),
('Jamie Foxx', "Jamie Foxx is an American actor, singer and comedian. He won an Academy Award for Best Actor, BAFTA Award for Best Actor in a Leading Role, and Golden Globe Award for Best Actor in a Musical or Comedy, for his work in the biographical film Ray (2004). The same year, he was nominated for the Academy Award for Best Supporting Actor for his role in the action film Collateral (2004)."),
('Christoph Waltz', "Christoph Waltz is an Austrian-German actor. He is known for his work with American filmmaker Quentin Tarantino, receiving acclaim for portraying SS-Standartenführer Hans Landa in Inglourious Basterds (2009) and bounty hunter Dr. King Schultz in Django Unchained (2012). For each performance, he won an Academy Award, a BAFTA Award, and a Golden Globe Award for Best Supporting Actor."),
('Leonardo DiCaprio', "Few actors in the world have had a career quite as diverse as Leonardo DiCaprio's. DiCaprio has gone from relatively humble beginnings, as a supporting cast member of the sitcom Growing Pains (1985) and low budget horror movies, such as Critters 3 (1991), to a major teenage heartthrob in the 1990s, as the hunky lead actor in movies such as Romeo + Juliet (1996) and Titanic (1997), to then become a leading man in Hollywood blockbusters, made by internationally renowned directors"),
('Jonah Hill', "Jonah Hill was born and raised in Los Angeles, the son of Sharon Feldstein (née Chalkin), a fashion designer and costume stylist, and Richard Feldstein, a tour accountant for Guns N' Roses. He is the brother of music manager Jordan Feldstein and actress Beanie Feldstein. He graduated from Crossroads School in Santa Monica and went on to The New School in New York to study drama."),
('Channing Tatum', "Channing Tatum was born in a small town, Cullman, Alabama, 50 miles north of Birmingham. He is the son of Kay (Faust), an airline worker, and Glenn Matthew Tatum, who worked in construction. Growing up, he was full of energy and somewhat troublesome, so his parents decided to enroll him in different sports such as track and field, baseball, soccer, and football to keep him out of trouble."),
('Ice Cube', "Ice Cube was born in South Central Los Angeles, to Doris (Benjamin), a custodian and hospital clerk, and Hosea Jackson, a UCLA groundskeeper. He first came to public notice as a singer and songwriter with the controversial and influential band N.W.A. His compositions with that group included many of the classic cuts from their debut LP Straight Outta Compton (Ruthless/Priority, 1989), including the title track, Gangsta Gangsta and Express Yourself."),
('Tim Robbins', "Born in West Covina, California, but raised in New York City, Tim Robbins is the son of former The Highwaymen singer Gil Robbins and actress Mary Robbins (née Bledsoe). Robbins studied drama at UCLA, where he graduated with honors in 1981."),
('Morgan Freeman', "With an authoritative voice and calm demeanor, this ever popular American actor has grown into one of the most respected figures in modern US cinema. Morgan was born on June 1, 1937 in Memphis, Tennessee, to Mayme Edna (Revere), a teacher, and Morgan Porterfield Freeman, a barber. The young Freeman attended Los Angeles City College before serving several years in the US Air Force as a mechanic between 1955 and 1959."),
('Bob Gunton', "Bob Gunton is an American actor, primarily known for portraying strict and authoritarian characters in popular films. His better known roles include Chief George Earle in Demolition Man (1993), Prison Warden Samuel Norton in The Shawshank Redemption (1994), medical school dean Dr. Walcott in Patch Adams (1998), and politician Cyrus Vance in Argo (2012)."),
('Joseph Gordon-Levitt', "Joseph Leonard Gordon-Levitt was born February 17, 1981 in Los Angeles, California, to Jane Gordon and Dennis Levitt. Joseph was raised in a Jewish family with his late older brother, Dan Gordon-Levitt, who passed away in October 2010. His parents worked for the Pacifica Radio station KPFK-FM and his maternal grandfather, Michael Gordon, had been a well-known movie director."),
('Tom Hardy', "With his breakthrough performance as Eames in Christopher Nolan's sci-fi thriller Inception (2010), English actor Tom Hardy has been brought to the attention of mainstream audiences worldwide. However, the versatile actor has been steadily working on both stage and screen since his television debut in the miniseries Band of Brothers (2001)."),
('Cillian Murphy', "Striking Irish actor Cillian Murphy was born in Douglas, the oldest child of Brendan Murphy, who works for the Irish Department of Education, and a mother who is a teacher of French. He has three younger siblings. Murphy was educated at Presentation Brothers College, Cork. He went on to study law at University College Cork, but dropped out after about a year.");


INSERT INTO movies_stars (movies_id, stars_id)
VALUES
(1, 1),
(1, 2),
(1, 3),
(2, 4),
(2, 5),
(2, 6), 
(3, 7),
(3, 8),
(3, 9),
(4, 10),
(4, 11),
(4, 12),
(5, 6),
(5, 13),
(5, 14),
(5, 15);



INSERT INTO genres (name)
VALUES
('Action'),
('Comedy'),
('Drama'),
('Sci-Fi');

INSERT INTO movies_genres(movies_id, genres_id)
VALUES 
(1, 1),
(2, 1),
(3, 2),
(4, 3),
(5, 4);


SELECT * FROM movies_directors;

SELECT d.name, m.title FROM directors d
INNER JOIN movies m
WHERE d.id = m.id;