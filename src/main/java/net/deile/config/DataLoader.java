package net.deile.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
// import net.deile.model.Comment;
import net.deile.repository.CommentRepository;

@RequiredArgsConstructor
@Component
public class DataLoader implements CommandLineRunner {

	private final CommentRepository repository;

	@Override
	public void run(String... args) throws Exception {
//		Comment comment = new Comment();
//		comment.setContent("こんにちは");
//
//		repository.save(comment);
//
//		comment = new Comment();
//		comment.setContent("Test comment");
//		repository.save(comment);
	}

}
