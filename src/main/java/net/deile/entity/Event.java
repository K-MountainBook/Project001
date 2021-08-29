package net.deile.entity;

import lombok.Data;

@Data
public class Event {

	private String event_id;

	private String title;

	private String details;

	private String address;

	private Integer max_participant;

	private String participant;

	private String tentative_participant;

	private Boolean public_flag;

}
