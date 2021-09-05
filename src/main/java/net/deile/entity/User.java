package net.deile.entity;

import javax.persistence.Table;

import lombok.Data;

@Data
@Table(name = "user")
public class User {

	private String email;

	private String user_name;

	private String user_id;

	private String password;

	private String twitter;

	private String facebook;

	private String bio;

	private String homepage;

	private String group_id;

}
