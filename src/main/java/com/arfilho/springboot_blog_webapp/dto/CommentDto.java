package com.arfilho.springboot_blog_webapp.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CommentDto {
    private Long id;
    @NotEmpty(message = "Name should not be empty!")
    private String name;
    @NotEmpty(message = "Email should not be empty or null!")
    @Email
    private String email;
    @NotEmpty(message = "Comment body should not be empty!")
    private String content;
    private LocalDateTime createdOn;
    private LocalDateTime updatedOn;
}
