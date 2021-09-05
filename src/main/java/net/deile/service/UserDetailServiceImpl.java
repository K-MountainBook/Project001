package net.deile.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.deile.entity.User;
import net.deile.repository.UserRepository;
import net.deile.service.interfaces.UserDetailService;

@Service
public class UserDetailServiceImpl implements UserDetailService {

	@Autowired
	UserRepository userRepository;

	@Transactional
	public boolean signUpUser(User user) {
		//
		boolean result = true;
		//
		//		try {
		//			userRepository.save(user);
		//		} catch (IllegalArgumentException e) {
		//			result = false;
		//		}

		//		List<User> list = userRepository.findUser(user.getEmail());
		//		System.out.println(list.size());

		return result;

	}

	@Override
	public List<User> findByEmail(String email) {
		return userRepository.findByEmail(email);
	}

}
