use whattosee_db;

insert into person(birth, country, name, person_type_id) values (now(), 'USA', 'Productor 1', (select pt.id from person_type pt where pt.name = 'productor'));
insert into person(birth, country, name, person_type_id) values (now(), 'Colombia', 'Productor 2', (select pt.id from person_type pt where pt.name = 'productor'));
insert into person(birth, country, name, person_type_id) values (now(), 'UK', 'Productor 3', (select pt.id from person_type pt where pt.name = 'productor'));
insert into person(birth, country, name, person_type_id) values (now(), 'Russia', 'Productor 4', (select pt.id from person_type pt where pt.name = 'productor'));
insert into person(birth, country, name, person_type_id) values (now(), 'Canada', 'Productor 5', (select pt.id from person_type pt where pt.name = 'productor'));