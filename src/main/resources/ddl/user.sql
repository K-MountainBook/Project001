create table user(
email varchar(64) PRIMARY KEY,
user_id varchar(8) NULL,
user_name varchar(32) NULL,
password varchar(128),
twitter varchar(32) NULL,
facebook varchar(256) NULL,
bio varchar(256) NULL,
homepage varchar(256) NULL,
group_id varchar(64) NULL
);


delete from user where email = 'test'

insert into user (email, password, user_name) values('test','{bcrypt}$2a$10$OODsUZn4T5MRILPQZDNMFu6SamGLYVzMozkoCM/BZl7mXzroTMzAW', 'テストユーザ０１');
