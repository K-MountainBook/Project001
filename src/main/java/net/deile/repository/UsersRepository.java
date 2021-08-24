package net.deile.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.deile.model.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {

}
