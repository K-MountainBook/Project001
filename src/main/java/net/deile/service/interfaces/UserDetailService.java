package net.deile.service.interfaces;

import java.util.List;

import net.deile.entity.User;

/**
 * Userテーブルに対するinterface
 * @author k_yamamoto
 *
 */
public interface UserDetailService {

	/**
	 * Emailを条件にしたUserテーブルの検索
	 * @param email メールアドレス（ユニークキー）
	 * @return 取得したUserテーブルのList（通常は1レコード）
	 */
	public List<User> findByEmail(String email);

}
