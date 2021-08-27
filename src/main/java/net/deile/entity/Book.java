package net.deile.entity;

import org.springframework.data.annotation.Id;

import lombok.Data;

@Data
public class Book {
	@Id
	private Long id;

	private String title;
	private String detail;

}
