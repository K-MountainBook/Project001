package net.deile.repository;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import net.deile.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, String> {

	@Query(value = "select * from user where email = :email")
	public List<User> findByEmail(@Param("email") String email);

	<S extends User> S save(User user);

}
