package net.deile.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import net.deile.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, String> {

	User findByemail(String email);

}
