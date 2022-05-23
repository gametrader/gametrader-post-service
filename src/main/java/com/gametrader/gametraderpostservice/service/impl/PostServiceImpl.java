package com.gametrader.gametraderpostservice.service.impl;

import com.gametrader.gametraderpostservice.dto.PostDto;
import com.gametrader.gametraderpostservice.entity.Image;
import com.gametrader.gametraderpostservice.entity.PostEntity;
import com.gametrader.gametraderpostservice.mapper.PostMapper;
import com.gametrader.gametraderpostservice.model.Category;
import com.gametrader.gametraderpostservice.repository.PostRepository;
import com.gametrader.gametraderpostservice.service.PostService;
import com.gametrader.gametraderpostservice.service.StorageService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;
    private final PostMapper postMapper;
    private final StorageService storageService;
    @Override
    public void createPost(PostDto dto, Set<MultipartFile> file) {
        Set<Image> images = new HashSet<>();
        for (MultipartFile multipartFile : file) {
            images.add(Image.builder().fileName(storageService.uploadFile(multipartFile)).build());
        }
        PostEntity postEntity = postMapper.dtoToEntity(dto);
        postEntity.setImage(images);
        postRepository.save(postEntity);
    }

    @Override
    public void updatePost(PostDto dto, Long id, Set<MultipartFile> files) {
        PostEntity oldPost = postRepository.getById(id);
        oldPost.getImage().forEach(image -> storageService.deleteFile(image.getFileName()));

        Set<Image> images = new HashSet<>();
        for (MultipartFile file : files) {
            images.add(Image.builder().fileName(storageService.uploadFile(file)).build());
        }
        PostEntity newEntity = postMapper.dtoToEntity(dto);
        newEntity.setId(oldPost.getId());
        newEntity.setImage(images);
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
