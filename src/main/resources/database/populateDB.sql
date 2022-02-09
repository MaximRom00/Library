insert into member(name, telephone_number)
    value ('Max', 3271199),
    ('Anna', 1112233),
    ('Dima', 7890091),
    ('Olga', 5455454),
    ('Misha', 9871333),
    ('Andrey', 9876541);

insert into authors(name)
    value ('Orwell'),
    ('Dostoevsky'),
    ('Gogol'),
    ('Exupery');
insert into books(name, year, author_id)
    VALUE ('The Idiot', 1868, 2),
    ('The Brothers Karamazov', 1880, 2),
    ('1984', 1949, 1),
    ('Little Prince' , 1943, 4);
insert into library(book_id, member_id, is_active)
    VALUE (1, 2, true),
    (1, 3, false),
    (2, 1, true),
    (4, 4, true);