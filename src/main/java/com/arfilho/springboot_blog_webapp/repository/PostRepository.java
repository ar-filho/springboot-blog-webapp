package com.arfilho.springboot_blog_webapp.repository;

import com.arfilho.springboot_blog_webapp.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PostRepository extends JpaRepository<Post, Long> {
    Optional<Post> findByUrl(String url);
}
