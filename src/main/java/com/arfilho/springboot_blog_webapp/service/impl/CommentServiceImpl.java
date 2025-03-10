package com.arfilho.springboot_blog_webapp.service.impl;

import com.arfilho.springboot_blog_webapp.dto.CommentDto;
import com.arfilho.springboot_blog_webapp.entity.Comment;
import com.arfilho.springboot_blog_webapp.entity.Post;
import com.arfilho.springboot_blog_webapp.entity.User;
import com.arfilho.springboot_blog_webapp.mapper.CommentMapper;
import com.arfilho.springboot_blog_webapp.repository.CommentRepository;
import com.arfilho.springboot_blog_webapp.repository.PostRepository;
import com.arfilho.springboot_blog_webapp.repository.UserRepository;
import com.arfilho.springboot_blog_webapp.service.CommentService;
import com.arfilho.springboot_blog_webapp.util.SecurityUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentServiceImpl implements CommentService {

    private CommentRepository commentRepository;
    private PostRepository postRepository;
    private UserRepository userRepository;

    public CommentServiceImpl(CommentRepository commentRepository,
                              PostRepository postRepository,
                              UserRepository userRepository) {
        this.commentRepository = commentRepository;
        this.postRepository = postRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void createComment(String postUrl, CommentDto commentDto) {
        Post post = postRepository.findByUrl(postUrl).get();
        Comment comment = CommentMapper.mapToComment(commentDto);
        comment.setPost(post);
        commentRepository.save(comment);
    }

    @Override
    public List<CommentDto> findAllComments() {
        List<Comment> comments = commentRepository.findAll();
        return comments.stream()
                .map(CommentMapper::mapToCommentDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteComment(Long commentId) {
        commentRepository.deleteById(commentId);
    }

    @Override
    public List<CommentDto> findCommentsByPost() {
        String email = SecurityUtils.getCurrentUser().getUsername();
        User createdBy = userRepository.findByEmail(email);
        Long userId = createdBy.getId();
        List<Comment> comments = commentRepository.findCommentByPost(userId);
        return comments.stream()
                .map(CommentMapper::mapToCommentDto).collect(Collectors.toList());
    }
}
