INSERT INTO profiles(login, email, name, surname, password, ip, role)
VALUES ('lukas', 'bed46@wp.pl', 'Lukasz', 'Bednarski', 'root', '255.255.255.12', 'user');
INSERT INTO profiles(login, email, name, surname, password, ip, role)
VALUES ('pangeon', 'pangeon@tlen.pl', 'Kamil', 'Cecherz', 'root', '255.255.255.9', 'admin');


INSERT INTO courses (title, start_date, end_date, description, max_attende)
VALUES ('Nowoczesne aplikacje w Java EE',
        '2019-05-20 14:30:00',
        '2019-07-20 16:00:00',
        'Tworzenie aplikacji z wykorzystaniem JDBC, Servletów, MYSQL, JSP',
        12);

INSERT INTO courses (title, start_date, end_date, description, max_attende)
VALUES ('Podstawy HTML I CSS',
        '2019-05-20 18:30:00',
        '2019-05-25 18:30:00',
        'Nauka tworzenia stron WWW od podstaw, FTP',
        30);

INSERT INTO courses (title, start_date, end_date, description, max_attende)
VALUES ('Analiza danych tekstowych i języka naturalnego (Python)',
        '2019-07-10 12:30:00',
        '2019-07-13 17:00:00',
        'Nauczenie szeregu narzędzi do pracy z danymi tekstowymi, przedstawienie szeregu
        przykładów użycia pokrywających większość tematów tej dziedziny.',
        10);

INSERT INTO subscribtions (subs_idprof, subs_idcour)
VALUES (1, 1);
INSERT INTO subscribtions (subs_idprof, subs_idcour)
VALUES (1, 2);
INSERT INTO subscribtions (subs_idprof, subs_idcour)
VALUES (2, 1);
INSERT INTO subscribtions (subs_idprof, subs_idcour)
VALUES (2, 2);

INSERT INTO subscribtions (subs_idprof, subs_idcour)
VALUES (1, 3);


SELECT profiles.id_profile, profiles.login, courses.id_course, courses.title, subscribtions.id_subscribtions
FROM profiles,
     courses,
     subscribtions
WHERE profiles.id_profile = subscribtions.subs_idprof
  AND courses.id_course = subscribtions.subs_idcour;



SELECT profiles.id_profile, profiles.login, courses.id_course, courses.title,
       subscribtions.id_subscribtions, subscribtions.subs_idprof, subscribtions.subs_idcour
FROM profiles, courses, subscribtions
WHERE profiles.id_profile = subscribtions.subs_idprof AND courses.id_course = subscribtions.subs_idcour;

ALTER DATABASE db_bed CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci;