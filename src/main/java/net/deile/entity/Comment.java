package net.deile.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
@Entity
public class Comment {

	@Id
	@GeneratedValue
	private Long id;

	@NotBlank
	@Size(max = 40)
	private String content;

}
