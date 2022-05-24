package com.gametrader.gametraderpostservice.service;

import com.gametrader.gametraderpostservice.dto.PostDto;
import com.gametrader.gametraderpostservice.model.Category;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Set;


public interface PostService {

    void createPost(PostDto dto, Set<MultipartFile> file);
    void updatePost(PostDto dto, Set<MultipartFile> files);
    PostDto getPostById(Long id);
    List<PostDto> getAllPosts();
    List<PostDto> getPostsByAuthorId(Long authorId);
    List<PostDto> getPostsByLocalization(String localization);
    List<PostDto> getPostsByCategory(Category category);
}
