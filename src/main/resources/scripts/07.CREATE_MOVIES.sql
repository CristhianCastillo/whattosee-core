use whattosee_db;
-- Movies
insert into movie (name, score, score_counter, classification_id) values ('Movie 1', 0, 0, (select c.id from classification c where c.name = 'Rated G'));
insert into movie (name, score, score_counter, classification_id) values ('Movie 2', 0, 0, (select c.id from classification c where c.name = 'Rated G'));
insert into movie (name, score, score_counter, classification_id) values ('Movie 3', 0, 0, (select c.id from classification c where c.name = 'Rated G'));
insert into movie (name, score, score_counter, classification_id) values ('Movie 4', 0, 0, (select c.id from classification c where c.name = 'Rated G'));
insert into movie (name, score, score_counter, classification_id) values ('Movie 5', 0, 0, (select c.id from classification c where c.name = 'Rated G'));

insert into movie (name, score, score_counter, classification_id) values ('Movie 6', 0, 0, (select c.id from classification c where c.name = 'Rated PG'));
insert into movie (name, score, score_counter, classification_id) values ('Movie 7', 0, 0, (select c.id from classification c where c.name = 'Rated PG'));
insert into movie (name, score, score_counter, classification_id) values ('Movie 8', 0, 0, (select c.id from classification c where c.name = 'Rated PG'));
insert into movie (name, score, score_counter, classification_id) values ('Movie 9', 0, 0, (select c.id from classification c where c.name = 'Rated PG'));
insert into movie (name, score, score_counter, classification_id) values ('Movie 10', 0, 0, (select c.id from classification c where c.name = 'Rated PG'));

insert into movie (name, score, score_counter, classification_id) values ('Movie 11', 0, 0, (select c.id from classification c where c.name = 'Rated PG-13'));
insert into movie (name, score, score_counter, classification_id) values ('Movie 12', 0, 0, (select c.id from classification c where c.name = 'Rated PG-13'));
insert into movie (name, score, score_counter, classification_id) values ('Movie 13', 0, 0, (select c.id from classification c where c.name = 'Rated PG-13'));
insert into movie (name, score, score_counter, classification_id) values ('Movie 14', 0, 0, (select c.id from classification c where c.name = 'Rated PG-13'));
insert into movie (name, score, score_counter, classification_id) values ('Movie 15', 0, 0, (select c.id from classification c where c.name = 'Rated PG-13'));

-- Movies / Actors
insert into movie_actor (id_movie, id_actor) values ((select m.id from movie m where m.name = 'Movie 1'), (select p.id from person p where p.name = 'Actor 1'));
insert into movie_actor (id_movie, id_actor) values ((select m.id from movie m where m.name = 'Movie 2'), (select p.id from person p where p.name = 'Actor 1'));
insert into movie_actor (id_movie, id_actor) values ((select m.id from movie m where m.name = 'Movie 3'), (select p.id from person p where p.name = 'Actor 1'));
insert into movie_actor (id_movie, id_actor) values ((select m.id from movie m where m.name = 'Movie 4'), (select p.id from person p where p.name = 'Actor 1'));
insert into movie_actor (id_movie, id_actor) values ((select m.id from movie m where m.name = 'Movie 5'), (select p.id from person p where p.name = 'Actor 2'));

insert into movie_actor (id_movie, id_actor) values ((select m.id from movie m where m.name = 'Movie 6'), (select p.id from person p where p.name = 'Actor 2'));
insert into movie_actor (id_movie, id_actor) values ((select m.id from movie m where m.name = 'Movie 7'), (select p.id from person p where p.name = 'Actor 2'));
insert into movie_actor (id_movie, id_actor) values ((select m.id from movie m where m.name = 'Movie 8'), (select p.id from person p where p.name = 'Actor 3'));
insert into movie_actor (id_movie, id_actor) values ((select m.id from movie m where m.name = 'Movie 9'), (select p.id from person p where p.name = 'Actor 3'));
insert into movie_actor (id_movie, id_actor) values ((select m.id from movie m where m.name = 'Movie 10'), (select p.id from person p where p.name = 'Actor 3'));

insert into movie_actor (id_movie, id_actor) values ((select m.id from movie m where m.name = 'Movie 11'), (select p.id from person p where p.name = 'Actor 4'));
insert into movie_actor (id_movie, id_actor) values ((select m.id from movie m where m.name = 'Movie 12'), (select p.id from person p where p.name = 'Actor 4'));
insert into movie_actor (id_movie, id_actor) values ((select m.id from movie m where m.name = 'Movie 13'), (select p.id from person p where p.name = 'Actor 5'));
insert into movie_actor (id_movie, id_actor) values ((select m.id from movie m where m.name = 'Movie 14'), (select p.id from person p where p.name = 'Actor 5'));
insert into movie_actor (id_movie, id_actor) values ((select m.id from movie m where m.name = 'Movie 15'), (select p.id from person p where p.name = 'Actor 5'));

-- Movies / Productors
insert into movie_productor (id_movie, id_productor) values ((select m.id from movie m where m.name = 'Movie 1'), (select p.id from person p where p.name = 'Productor 1'));
insert into movie_productor (id_movie, id_productor) values ((select m.id from movie m where m.name = 'Movie 2'), (select p.id from person p where p.name = 'Productor 2'));
insert into movie_productor (id_movie, id_productor) values ((select m.id from movie m where m.name = 'Movie 3'), (select p.id from person p where p.name = 'Productor 3'));
insert into movie_productor (id_movie, id_productor) values ((select m.id from movie m where m.name = 'Movie 4'), (select p.id from person p where p.name = 'Productor 4'));
insert into movie_productor (id_movie, id_productor) values ((select m.id from movie m where m.name = 'Movie 5'), (select p.id from person p where p.name = 'Productor 5'));

insert into movie_productor (id_movie, id_productor) values ((select m.id from movie m where m.name = 'Movie 6'), (select p.id from person p where p.name = 'Productor 1'));
insert into movie_productor (id_movie, id_productor) values ((select m.id from movie m where m.name = 'Movie 7'), (select p.id from person p where p.name = 'Productor 2'));
insert into movie_productor (id_movie, id_productor) values ((select m.id from movie m where m.name = 'Movie 8'), (select p.id from person p where p.name = 'Productor 3'));
insert into movie_productor (id_movie, id_productor) values ((select m.id from movie m where m.name = 'Movie 9'), (select p.id from person p where p.name = 'Productor 4'));
insert into movie_productor (id_movie, id_productor) values ((select m.id from movie m where m.name = 'Movie 10'), (select p.id from person p where p.name = 'Productor 5'));

insert into movie_productor (id_movie, id_productor) values ((select m.id from movie m where m.name = 'Movie 11'), (select p.id from person p where p.name = 'Productor 1'));
insert into movie_productor (id_movie, id_productor) values ((select m.id from movie m where m.name = 'Movie 12'), (select p.id from person p where p.name = 'Productor 2'));
insert into movie_productor (id_movie, id_productor) values ((select m.id from movie m where m.name = 'Movie 13'), (select p.id from person p where p.name = 'Productor 3'));
insert into movie_productor (id_movie, id_productor) values ((select m.id from movie m where m.name = 'Movie 14'), (select p.id from person p where p.name = 'Productor 4'));
insert into movie_productor (id_movie, id_productor) values ((select m.id from movie m where m.name = 'Movie 15'), (select p.id from person p where p.name = 'Productor 5'));

-- Movies / Genders
insert into movie_gender (id_movie, id_gender) values ((select m.id from movie m where m.name = 'Movie 1'), (select g.id from gender g where g.name = 'Comedias'));
insert into movie_gender (id_movie, id_gender) values ((select m.id from movie m where m.name = 'Movie 2'), (select g.id from gender g where g.name = 'Comedias'));
insert into movie_gender (id_movie, id_gender) values ((select m.id from movie m where m.name = 'Movie 3'), (select g.id from gender g where g.name = 'Comedias'));
insert into movie_gender (id_movie, id_gender) values ((select m.id from movie m where m.name = 'Movie 4'), (select g.id from gender g where g.name = 'Comedias'));
insert into movie_gender (id_movie, id_gender) values ((select m.id from movie m where m.name = 'Movie 5'), (select g.id from gender g where g.name = 'Comedias'));

insert into movie_gender (id_movie, id_gender) values ((select m.id from movie m where m.name = 'Movie 6'), (select g.id from gender g where g.name = 'Dramaticas'));
insert into movie_gender (id_movie, id_gender) values ((select m.id from movie m where m.name = 'Movie 7'), (select g.id from gender g where g.name = 'Dramaticas'));
insert into movie_gender (id_movie, id_gender) values ((select m.id from movie m where m.name = 'Movie 8'), (select g.id from gender g where g.name = 'Dramaticas'));
insert into movie_gender (id_movie, id_gender) values ((select m.id from movie m where m.name = 'Movie 9'), (select g.id from gender g where g.name = 'Dramaticas'));
insert into movie_gender (id_movie, id_gender) values ((select m.id from movie m where m.name = 'Movie 10'), (select g.id from gender g where g.name = 'Dramaticas'));

insert into movie_gender (id_movie, id_gender) values ((select m.id from movie m where m.name = 'Movie 11'), (select g.id from gender g where g.name = 'Musicales'));
insert into movie_gender (id_movie, id_gender) values ((select m.id from movie m where m.name = 'Movie 12'), (select g.id from gender g where g.name = 'Musicales'));
insert into movie_gender (id_movie, id_gender) values ((select m.id from movie m where m.name = 'Movie 13'), (select g.id from gender g where g.name = 'Musicales'));
insert into movie_gender (id_movie, id_gender) values ((select m.id from movie m where m.name = 'Movie 14'), (select g.id from gender g where g.name = 'Musicales'));
insert into movie_gender (id_movie, id_gender) values ((select m.id from movie m where m.name = 'Movie 15'), (select g.id from gender g where g.name = 'Musicales'));
