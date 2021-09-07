package net.deile.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.deile.entity.User;
import net.deile.repository.UserRepository;
import net.deile.service.interfaces.UserDetailService;

@Service
public class UserDetailServiceImpl implements UserDetailService {

	@Autowired
	UserRepository userRepository;

	@Bean
	public PasswordEncoder passwordEncoder() {
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();

	}

	Logger logger = LoggerFactory.getLogger(Thread.currentThread().getStackTrace()[1].getClassName());

	public boolean signUpUser(User user) {
		//
		boolean result = true;

		List<User> userexists = userRepository.findByEmail(user.getEmail());

		if (userexists.size() > 0) {
			result = false;
		}

		if (result) {
			// データ登録処理
			String email = user.getEmail();
			String pswd = passwordEncoder().encode(user.getPassword());
			int insertCnt = userRepository.insert(email, pswd);
			if (insertCnt != 1) {
				result = false;
			}
		}

		return result;

	}

	@Override
	public List<User> findByEmail(String email) {
		return userRepository.findByEmail(email);
	}

}
