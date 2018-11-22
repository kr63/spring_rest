insert into friend (id, age, first_name, last_name, married)
values
       (1, 30, 'firstname1', 'lastname1', 1),
       (2, 40, 'firstname2', 'lastname2', 0),
       (3, 50, 'firstname3', 'lastname3', 1);

insert into address (id, city, street, friend_id)
values
       (1, 'city1', 'street1', 1),
       (2, 'city2', 'street2', 2),
       (3, 'city3', 'street3', 3);
