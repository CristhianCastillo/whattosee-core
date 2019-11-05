use whattosee_db;

insert into person(birth, country, name, person_type_id) values (now(), 'USA', 'Actor 1', (select pt.id from person_type pt where pt.name = 'actor'));
insert into person(birth, country, name, person_type_id) values (now(), 'Colombia', 'Actor 2', (select pt.id from person_type pt where pt.name = 'actor'));
insert into person(birth, country, name, person_type_id) values (now(), 'UK', 'Actor 3', (select pt.id from person_type pt where pt.name = 'actor'));
insert into person(birth, country, name, person_type_id) values (now(), 'Russia', 'Actor 4', (select pt.id from person_type pt where pt.name = 'actor'));
insert into person(birth, country, name, person_type_id) values (now(), 'Canada', 'Actor 5', (select pt.id from person_type pt where pt.name = 'actor'));