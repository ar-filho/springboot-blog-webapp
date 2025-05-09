package com.arfilho.springboot_blog_webapp.repository;

import com.arfilho.springboot_blog_webapp.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface PostRepository extends JpaRepository<Post, Long> {
    Optional<Post> findByUrl(String url);

    @Query("SELECT p from Post p WHERE " +
            "p.title LIKE CONCAT('%', :query, '%' ) OR " +
            "p.shortDescription LIKE CONCAT('%', :query, '%')")
    List<Post> searchPosts(String query);

    @Query(value = "SELECT * FROM posts p WHERE p.created_by =:userId", nativeQuery = true)
    List<Post> findPostByUser(Long userId);
}
