package net.deile.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.deile.model.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {

}
