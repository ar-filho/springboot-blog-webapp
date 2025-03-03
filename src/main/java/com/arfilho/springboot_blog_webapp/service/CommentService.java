package com.arfilho.springboot_blog_webapp.service;

import com.arfilho.springboot_blog_webapp.dto.CommentDto;

public interface CommentService {
    void createComment(String postUrl, CommentDto commentDto);
}
