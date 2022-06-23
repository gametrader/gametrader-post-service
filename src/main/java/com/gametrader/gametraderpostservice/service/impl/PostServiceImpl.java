package com.gametrader.gametraderpostservice.service.impl;

import com.gametrader.gametraderpostservice.dto.PostDto;
import com.gametrader.gametraderpostservice.entity.PostEntity;
import com.gametrader.gametraderpostservice.mapper.PostMapper;
import com.gametrader.gametraderpostservice.model.Category;
import com.gametrader.gametraderpostservice.repository.ImageRepository;
import com.gametrader.gametraderpostservice.repository.PostRepository;
import com.gametrader.gametraderpostservice.service.PostService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;
    private final ImageRepository imageRepository;
    private final PostMapper postMapper;
    @Override
    public void createPost(PostDto dto) {
        PostEntity postEntity = postMapper.dtoToEntity(dto);
        imageRepository.saveAll(postEntity.getImage());
        postRepository.save(postEntity);
    }

    @Override
    public void updatePost(PostDto dto) {
        PostEntity newEntity = postMapper.dtoToEntity(dto);
        imageRepository.saveAll(newEntity.getImage());
        postRepository.save(newEntity);
    }

    @Override
    public PostDto getPostById(Long id) {
        return postMapper.entityToDto(postRepository.getById(id));
    }

    @Override
    public List<PostDto> getAllPosts() {
        return postRepository.findAll()
                .stream()
                .map(postMapper::entityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<PostDto> getPostsByAuthorId(Long authorId) {
        return postRepository.findAllByAuthorId(authorId)
                .stream()
                .map(postMapper::entityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<PostDto> getPostsByLocalization(String localization) {
        return postRepository.findAllByLocalization(localization)
                .stream()
                .map(postMapper::entityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<PostDto> getPostsByCategory(Category category) {
        return postRepository.findAllByCategory(category)
                .stream()
                .map(postMapper::entityToDto)
                .collect(Collectors.toList());
    }
}
