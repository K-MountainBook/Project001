package net.deile.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import net.deile.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {

//	private final JdbcTemplate jdbcTemplate;
//
//	List<Map<String, Object>> userList;
//
//	List<Users> list = new ArrayList<>();
//
//	@Autowired
//	public UsersRepository(JdbcTemplate jdbcTemplate) {
//		this.jdbcTemplate = jdbcTemplate;
//	}

//	public List<Users> getAll() {
//		String sql = "select * from users";
//		userList = jdbcTemplate.queryForList(sql);
//
//		for (Map<String, Object> rows : userList) {
//			Users user = new Users();
//			user.setUser_id((long) rows.get("user_id"));
//			user.setUser_name((String) rows.get("user_name"));
//			list.add(user);
//		}

//		return list;
//}

}
