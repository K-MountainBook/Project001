package net.deile.entity;

import org.springframework.data.annotation.Id;

import lombok.Data;

@Data
public class User {

	@Id
	private String email;

	private String user_id;

	private String password;

	private String twitter;

	private String facebook;

	private String bio;

	private String homepage;

	private String group_id;

}
