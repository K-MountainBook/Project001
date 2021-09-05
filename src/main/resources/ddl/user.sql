create table user(
email varchar(64) PRIMARY KEY,
user_id varchar(8) NULL,
user_name varchar(32) NULL,
password char(32),
twitter varchar(32) NULL,
facebook varchar(64) NULL,
bio varchar(256) NULL,
homepage varchar(64) NULL,
group_id varchar(64) NULL
);


insert into user (email, password) values('test','{noop}test');
