package net.deile.entity;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;

import lombok.Data;

@Data
public class Users {
	
	@Id
	private Long user_id;
	@NotBlank
	@Size(max = 60)
	private String user_name;
}
