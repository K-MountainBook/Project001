package net.deile.form;

import java.sql.Date;

import lombok.Data;

@Data
public class EventForm {

	private String title;

	private String details;

	private String address;

	private String date;

	private Integer max_participant;

	private Boolean public_flag;
}
