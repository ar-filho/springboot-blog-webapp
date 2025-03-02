package com.arfilho.springboot_blog_webapp.controller;

import com.arfilho.springboot_blog_webapp.dto.PostDto;
import com.arfilho.springboot_blog_webapp.service.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class PostController {

    private PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    // create handler method, GET request and return model and view
    @GetMapping("/admin/posts")
    public String posts(Model model) {
        List<PostDto> posts = postService.findAllPosts();
        model.addAttribute("posts", posts);
        return "/admin/posts";
    }

    // handler method to handle new post request
    @GetMapping("admin/posts/new-post")
    public String newPostForm(Model model) {
        PostDto postDto = new PostDto();
        model.addAttribute("post", postDto);
        return "admin/create_post";
    }

    // handler method to handle form submit request new post
    @PostMapping("/admin/posts")
    public String createPost(PostDto postDto) {
        postDto.setUrl(getUrl(postDto.getTitle()));
        postService.createPost(postDto);
        return "redirect:/admin/posts";
    }

    private static String getUrl(String postTitle) {
        // OOPS Concepts Explain in Java
        // oops-concepts-explain-in-java
        // String title = postTitle.trim().toLowerCase().replaceAll("\\s+","-");
        // String url = title.replaceAll("[^A-Za-z0-9]", "-");
        return postTitle
                        .trim()
                        .toLowerCase()
                        .replace(" ", "-")
                        .replaceAll("[^A-Za-z0-9]", "-");
    }
}
