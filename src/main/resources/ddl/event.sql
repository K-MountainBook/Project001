create table event(
 event_id CHAR(12) PRIMARY KEY,
 title VARCHAR(100),
 details TEXT,
 address VARCHAR(120),
 from_date datetime,
 to_date datetime,
 max_participant INT,
 participant INT,
 tentative_participant VARCHAR(100),
 public_flag BOOLEAN
);