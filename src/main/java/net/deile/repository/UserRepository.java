package net.deile.repository;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.deile.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, String> {

	@Query(value = "select * from user where email = :email")
	public List<User> findByEmail(@Param("email") String email);

	@Transactional
	@Modifying
	@Query(value = "insert into user ( email, password ) values ( :email, :password)")
	int insert(@Param("email") String email, @Param("password") String password);

}
