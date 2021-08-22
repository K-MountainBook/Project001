package net.deile;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class Users {
	@NotBlank
	private long user_id;
	@NotBlank
	@Size(max = 60)
	private String user_name;
}
