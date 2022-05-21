package com.gametrader.gametraderpostservice.service;

import com.gametrader.gametraderpostservice.dto.PostDto;
import com.gametrader.gametraderpostservice.model.Category;

import java.util.List;

public interface PostService {

    void createPost(PostDto dto);
    void updatePost(PostDto dto, Long id);
    PostDto getPostById(Long id);
    List<PostDto> getAllPosts();
    List<PostDto> getPostsByAuthorId(Long authorId);
    List<PostDto> getPostsByLocalization(String localization);
    List<PostDto> getPostsByCategory(Category category);
}
