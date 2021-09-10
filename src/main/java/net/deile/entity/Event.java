package net.deile.entity;

import java.sql.Timestamp;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import org.springframework.data.annotation.Id;

import lombok.Data;

@Data
@Table(name = "event")
public class Event {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long event_id;

	private String title;

	private String details;

	private String address;

	private Timestamp fromDate;

	private Timestamp toDate;

	private Integer max_participant;

	private Integer participant;

	private Boolean public_flag;

	private String owner;

}
