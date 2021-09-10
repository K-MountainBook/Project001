package net.deile.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import lombok.Data;

@Data
@Table(name = "Participant")
@IdClass(ParticipantPK.class)
public class Participant {

	@Id
	@Column(name = "event_id")
	private long event_id;

	@Id
	@Column(name = "email")
	private String email;

}
