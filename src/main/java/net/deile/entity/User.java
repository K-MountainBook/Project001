package net.deile.entity;

import javax.persistence.Table;

import org.springframework.data.annotation.Id;

import lombok.Data;

@Data
@Table(name = "user")
public class User {

	@Id
	private String email;

	private String user_name;

	private String user_id;

	private String password;

	private String twitter;

	private String facebook;

	private String bio;

	private String homepage;

	private String group_id;

	private boolean enable;

}
