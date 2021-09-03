create table user(
email varchar(64) PRIMARY KEY,
user_id varchar(8),
user_name varchar(32),
password char(32),
twitter varchar(32),
facebook varchar(64),
bio varchar(256),
homepage varchar(64),
group_id varchar(64)
);


insert into user (email, password) values('test','{noop}test');