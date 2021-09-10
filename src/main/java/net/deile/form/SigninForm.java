package net.deile.form;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class SigninForm {

	@NotBlank
	@Email
	private String email;

	@NotBlank
	private String pswd;
}
