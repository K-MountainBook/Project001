package net.deile.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import net.deile.entity.Account;
import net.deile.entity.User;
import net.deile.repository.UserRepository;

@Service
public class AccountDetailService implements UserDetailsService {

	@Autowired
	UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String email) {

		User user = userRepository.findByemail(email);
		if (user == null) {
			throw new UsernameNotFoundException(email);
		}

		return user;
	}

}
