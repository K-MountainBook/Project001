create table event(
 event_id BIGINT PRIMARY KEY,
 title VARCHAR(100),
 details TEXT,
 address VARCHAR(120),
 from_date datetime,
 to_date datetime,
 max_participant INT,
 participant INT,
 public_flag BOOLEAN
);