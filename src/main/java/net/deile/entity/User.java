package net.deile.entity;

import java.time.LocalDateTime;

import javax.persistence.Table;

import org.springframework.data.annotation.Id;

import lombok.Data;

/**
 * Entity of "USER" table.
 * 
 * @author k_yamamoto
 *
 */
@Data
@Table(name = "user")
public class User {

	@Id
	private String email;

	private String user_name;

	private String password;

	private String twitter;

	private String facebook;

	private String bio;

	private String homepage;

	private String group_id;

	private boolean enable;

	private LocalDateTime registered_date;

	private LocalDateTime updated_date;

	private String UUID;

}
