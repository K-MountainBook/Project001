package net.deile.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import net.deile.entity.Event;

@Repository
public interface EventRepository extends CrudRepository<Event, String> {

}
