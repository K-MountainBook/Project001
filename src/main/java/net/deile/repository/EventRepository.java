package net.deile.repository;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import net.deile.entity.Event;

@Repository
public interface EventRepository extends CrudRepository<Event, Long> {

	@Query("select e.* from event e where e.owner = :email")
	List<Event> findallByEmail(@Param("email") String owner);

}
