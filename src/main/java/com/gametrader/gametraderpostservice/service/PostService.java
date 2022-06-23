package com.gametrader.gametraderpostservice.service;

import com.gametrader.gametraderpostservice.dto.CategoryDto;
import com.gametrader.gametraderpostservice.dto.PostDto;

import java.util.List;


public interface PostService {

    void createPost(PostDto dto);
    void updatePost(PostDto dto);
    PostDto getPostById(Long id);
    List<PostDto> getAllPosts();
    List<PostDto> getPostsByAuthorId(Long authorId);
    List<PostDto> getPostsByLocalization(String localization);
    List<PostDto> getPostsByCategory(CategoryDto category);
}
