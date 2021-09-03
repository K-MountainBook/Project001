package net.deile.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "event")
public class Event {

	@Id
	private String event_id;

	private String title;

	private String details;

	private String address;

	private Integer max_participant;

	private Integer participant;

	private String tentative_participant;

	private Boolean public_flag;

}
