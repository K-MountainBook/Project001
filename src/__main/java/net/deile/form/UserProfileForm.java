package net.deile.form;

import java.sql.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import lombok.Data;

/**
 * ユーザ情報登録フォーム用
 * @author k_yamamoto
 *
 */
@Data
public class UserProfileForm {

	@Email
	@NotBlank
	private String email;

	private String user_name;

	@NotBlank
	private String uuid;

	private String password;

	private String twitter;

	private String facebook;

	private String bio;

	private String homepage;

	private String group_id;

	private boolean enable;

	private Date registered_date;

}
