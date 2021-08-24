package net.deile.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
@Entity
public class Users {
	@Id
	private Long user_id;
	@NotBlank
	@Size(max = 60)
	private String user_name;
}
