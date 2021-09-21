package net.deile.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

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

	public boolean signUpUser(User user) throws SQLException {
		//
		boolean result = true;

		Optional<User> userExists = userRepository.findById(user.getEmail());

		if (!userExists.isEmpty()) {
			result = false;
		}

		if (result) {
			// データ登録処理
			String email = user.getEmail();
			String pswd = passwordEncoder().encode(user.getPassword());
			String uuid = user.getUUID();

			// データの登録を行う。
			int insertCnt = userRepository.insert(email, pswd, uuid);
			// 登録件数が１件以外の場合例外を投げる
			if (insertCnt != 1) {
				throw new SQLException("ユーザのinsert処理に失敗しました。");
			}
		}

		return result;

	}

	public String checkUuid(String uuid) {
		// 万が一を考えてUUIDの重複チェックを行う
		while (!userRepository.checkUUID(uuid).isEmpty()) {
			// uuidが重複していた場合、再度生成する。
			logger.warn("UUID Exists. Regenarate UUID");
			uuid = UUID.randomUUID().toString();
		}
		return uuid;
	}

	@Override
	public List<User> findByEmail(String email) {
		return userRepository.findByEmail(email);
	}

}
