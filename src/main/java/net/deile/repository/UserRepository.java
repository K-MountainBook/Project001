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

	@Query(value = "select * from user where user_name = :userName")
	public List<User> findByUserName(@Param("userName") String userName);

	@Transactional
	@Modifying
	@Query(value = "insert into user ( email, password, enable, registered_date, updated_date, UUID ) values ( :email, :password, true, NOW(), NOW(), :UUID)")
	int insert(@Param("email") String email, @Param("password") String password, @Param("UUID") String uuid);

	@Transactional
	@Modifying
	@Query(value = "update user set user_name = :user_name, updated_date = NOW() where email = :email")
	int updateName(@Param("user_name") String name, @Param("email") String email);

	@Transactional
	@Modifying
	@Query(value = "update user set twitter = :twitter, facebook = :facebook, updated_date = NOW() where email = :email")
	int updateSNS(@Param("twitter") String twitter, @Param("facebook") String fb, @Param("email") String email);

	@Transactional
	@Modifying
	@Query(value = "update user set bio = :bio, updated_date = NOW() where email = :email")
	int updateBio(@Param("bio") String bio, @Param("email") String email);

	@Transactional
	@Modifying
	@Query(value = "update user set homepage = :homepage, updated_date = NOW() where email = :email")
	int updateHomepage(@Param("homepage") String homepage, @Param("email") String email);

	@Transactional
	@Modifying
	@Query(value = "update user set enable = :enable, updated_date = NOW() where email = :email")
	int updateEnable(@Param("enable") boolean enable, @Param("email") String email);

	@Query(value = "select * from user where UUID = :uuid")
	public List<User> checkUUID(@Param("uuid") String uuid);

}
