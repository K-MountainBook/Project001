create table event(
 event_id BIGINT AUTO_INCREMENT PRIMARY KEY,
 title VARCHAR(100),
 details TEXT,
 address VARCHAR(120),
 from_date timestamp,
 to_date timestamp,
 max_participant INT,
 participant INT,
 public_flag BOOLEAN,
 owner varchar(256)
);