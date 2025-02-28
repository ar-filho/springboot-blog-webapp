package com.arfilho.springboot_blog_webapp.service;

import com.arfilho.springboot_blog_webapp.dto.PostDto;

import java.util.List;

public interface PostService {
    List<PostDto> findAllPosts();
}
