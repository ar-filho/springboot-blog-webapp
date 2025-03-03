package com.arfilho.springboot_blog_webapp.repository;

import com.arfilho.springboot_blog_webapp.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    
}
