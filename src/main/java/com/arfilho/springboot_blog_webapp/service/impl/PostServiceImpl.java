package com.arfilho.springboot_blog_webapp.service.impl;

import com.arfilho.springboot_blog_webapp.dto.PostDto;
import com.arfilho.springboot_blog_webapp.entity.Post;
import com.arfilho.springboot_blog_webapp.mapper.PostMapper;
import com.arfilho.springboot_blog_webapp.repository.PostRepository;
import com.arfilho.springboot_blog_webapp.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    private PostRepository postRepository;

    @Autowired
    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public List<PostDto> findAllPosts() {
        List<Post> posts = postRepository.findAll();
        return posts.stream().map(PostMapper::mapToPostDto)
                .collect(Collectors.toList());
    }
}
