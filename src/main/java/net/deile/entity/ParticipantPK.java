package net.deile.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;

/**
 * Entity of "Participant" table Primary Key.
 * @author k_yamamoto
 *
 */
@Data
@Embeddable
public class ParticipantPK implements Serializable {

	@Column(name = "event_id")
	private long event_id;

	@Column(name = "email")
	private String email;

}
