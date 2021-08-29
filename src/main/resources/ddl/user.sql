create table user(
user_id varchar(8) PRIMARY KEY,
password char(32),
mail varchar(64),
twitter varchar(32),
facebook varchar(64),
bio varchar(256),
homepage varchar(64),
group_id varchar(64)
)