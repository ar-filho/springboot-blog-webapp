package com.arfilho.springboot_blog_webapp.repository;

import com.arfilho.springboot_blog_webapp.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    @Query(value = "SELECT c.* FROM comments c INNER JOIN posts p WHERE c.post_id = p.id AND p.created_by =:userId",
            nativeQuery = true)
    List<Comment> findCommentByPost(Long userId);
}
