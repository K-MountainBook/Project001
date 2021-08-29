package net.deile.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import net.deile.entity.Users;

@Repository
public interface UsersRepository extends CrudRepository<Users, String> {

}
