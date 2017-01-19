drop table BOOK;

CREATE TABLE BOOK(id int primary key not null, title varchar(255) not null, price DECIMAL(8,2) not null, author varchar2(255) not null, image varchar2(255) not null, link varchar2(255) not null);

INSERT INTO BOOK values (7, 'Seven is my lucky number', 7.77, 'Lucy Ascot', 'http://assignment.gae.golgek.mobi/static/7.jpg', '/api/v1/items/7');
INSERT INTO BOOK values (8, 'A Dance with Dragons', 19.01, 'George R.R. Martin', 'http://assignment.gae.golgek.mobi/static/8.jpg', '/api/v1/items/8');
INSERT INTO BOOK values (1, 'Enterprise Application Development with Ext JS and Spring', 153.55, 'Gerald Gierer', 'http://assignment.gae.golgek.mobi/static/1.jpg', '/api/v1/items/1');
INSERT INTO BOOK values (10, 'Ten ways to a better mind', 10, 'Brian Bowd', 'http://assignment.gae.golgek.mobi/static/10.jpg', '/api/v1/items/10');
INSERT INTO BOOK values (42, 'The Hitch-hikers Guide to the Galaxy', 5.62, 'Douglas Adams', 'http://assignment.gae.golgek.mobi/static/42.jpg', '/api/v1/items/42');
INSERT INTO BOOK values (200, 'Book title #200', 34, 'Author Name#200', 'http://assignment.gae.golgek.mobi/static/200.jpg', '/api/v1/items/200');
INSERT INTO BOOK values (201, 'Book title #201', 45, 'Author Name#201', 'http://assignment.gae.golgek.mobi/static/201.jpg', '/api/v1/items/201');
