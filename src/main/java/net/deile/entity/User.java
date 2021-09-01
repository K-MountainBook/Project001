package net.deile.entity;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;

import lombok.Data;

@Data
public class User extends org.springframework.security.core.userdetails.User {

	private String email;

	private String password;

	public User(String email, String password, Collection<? extends GrantedAuthority> authorities) {
		super(email, password, authorities);
		// TODO 自動生成されたコンストラクター・スタブ
	}

}
