package com.arfilho.springboot_blog_webapp.controller;

import com.arfilho.springboot_blog_webapp.dto.PostDto;
import com.arfilho.springboot_blog_webapp.service.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class BlogController {

    private PostService postService;

    public BlogController(PostService postService) {
        this.postService = postService;
    }

    // handler method to handle http://localhost:8080/
    @GetMapping("/")
    public String viewBlogPosts(Model model) {
        List<PostDto> postResponse =  postService.findAllPosts();
        model.addAttribute("postsResponse", postResponse);
        return "blog/view_posts";
    }

    // handler method to handle view post request
    @GetMapping("/post/{postUrl}")
    private String showPost(@PathVariable("postUrl") String postUrl,
                            Model model) {
        PostDto postDto = postService.findPostByUrl(postUrl);
        model.addAttribute("post", postDto);
        return "blog/blog_post";
    }
}
