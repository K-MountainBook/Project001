package net.deile.entity;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;

import lombok.Data;

@Data
public class Comment {

	@Id
	private Long id;

	@NotBlank
	@Size(max = 40)
	private String content;

}
