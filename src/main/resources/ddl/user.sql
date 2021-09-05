create table user(
email varchar(64) PRIMARY KEY,
user_id varchar(8) NULL,
user_name varchar(32) NULL,
password varchar(128),
twitter varchar(32) NULL,
facebook varchar(64) NULL,
bio varchar(256) NULL,
homepage varchar(64) NULL,
group_id varchar(64) NULL
);


insert into user (email, password) values('test','{bcrypt}$2a$10$OODsUZn4T5MRILPQZDNMFu6SamGLYVzMozkoCM/BZl7mXzroTMzAW');
