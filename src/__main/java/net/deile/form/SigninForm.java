package net.deile.form;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import lombok.Data;

/**
 * サインアップフォーム用
 * @author k_yamamoto
 *
 */
@Data
public class SigninForm {

	@NotBlank
	@Email
	private String email;

	@NotBlank
	private String pswd;
}
