package net.deile.service.interfaces;

import java.util.List;

import net.deile.entity.User;

public interface UserDetailService {

	public List<User> findByEmail(String email);

}
