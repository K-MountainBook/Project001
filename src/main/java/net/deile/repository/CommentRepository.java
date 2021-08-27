package net.deile.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import net.deile.entity.Comment;

@Repository
public interface CommentRepository extends CrudRepository<Comment, Long> {

}
