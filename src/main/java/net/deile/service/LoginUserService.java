package net.deile.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import net.deile.entity.User;
import net.deile.repository.UserRepository;

@Service
public class LoginUserService implements UserDetailsService {

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	public void authenticationLogin(String email, String pswd) {

		System.out.println("Running is " + this.getClass().toString());

		Optional<User> userInfo = userRepository.findById(email);

		if (userInfo.isEmpty()) {
			throw new UsernameNotFoundException("email");
		}

		if (passwordEncoder.matches(pswd, userInfo.get().getPassword())) {
			throw new UsernameNotFoundException("pswd");
		}

	}

}
