package net.deile.repository;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import net.deile.entity.Participant;
import net.deile.entity.ParticipantPK;

@Repository
public interface ParticipantRepository extends CrudRepository<Participant, ParticipantPK> {

	@Query("select p.* from participant p where p.event_id = :event_id and p.email = :email")
	Participant findByParticipantPrimaryKey(@Param("event_id") long event_id, @Param("email") String email);

}
