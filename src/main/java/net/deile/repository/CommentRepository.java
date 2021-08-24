package net.deile.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.deile.entity.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

}
