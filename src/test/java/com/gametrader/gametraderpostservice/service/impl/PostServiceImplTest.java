package com.gametrader.gametraderpostservice.service.impl;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.gametrader.gametraderpostservice.dto.PostDto;
import com.gametrader.gametraderpostservice.entity.PostEntity;
import com.gametrader.gametraderpostservice.mapper.PostMapper;
import com.gametrader.gametraderpostservice.model.Category;
import com.gametrader.gametraderpostservice.repository.PostRepository;

import java.util.ArrayList;

import java.util.HashSet;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {PostServiceImpl.class})
@ExtendWith(SpringExtension.class)
class PostServiceImplTest {
    @MockBean
    private PostMapper postMapper;

    @MockBean
    private PostRepository postRepository;

    @Autowired
    private PostServiceImpl postServiceImpl;

    /**
     * Method under test: {@link PostServiceImpl#createPost(PostDto)}
     */
    @Test
    void testCreatePost() {
        PostEntity postEntity = new PostEntity();
        postEntity.setAuthorId(123L);
        postEntity.setCategory(Category.GAMES);
        postEntity.setDescription("The characteristics of someone or something");
        postEntity.setEmailAddress("42 Main St");
        postEntity.setId(123L);
        postEntity.setImage(new HashSet<>());
        postEntity.setLocalization("Localization");
        postEntity.setPhoneNumber("4105551212");
        postEntity.setPrice(1L);
        postEntity.setPromoted(true);
        postEntity.setTitle("Dr");
        when(postRepository.save((PostEntity) any())).thenReturn(postEntity);

        PostEntity postEntity1 = new PostEntity();
        postEntity1.setAuthorId(123L);
        postEntity1.setCategory(Category.GAMES);
        postEntity1.setDescription("The characteristics of someone or something");
        postEntity1.setEmailAddress("42 Main St");
        postEntity1.setId(123L);
        postEntity1.setImage(new HashSet<>());
        postEntity1.setLocalization("Localization");
        postEntity1.setPhoneNumber("4105551212");
        postEntity1.setPrice(1L);
        postEntity1.setPromoted(true);
        postEntity1.setTitle("Dr");
        when(postMapper.dtoToEntity((PostDto) any())).thenReturn(postEntity1);
        PostDto postDto = new PostDto();
        postServiceImpl.createPost(postDto);
        verify(postRepository).save((PostEntity) any());
        verify(postMapper).dtoToEntity((PostDto) any());
        assertFalse(postDto.isPromoted());
    }

    /**
     * Method under test: {@link PostServiceImpl#updatePost(PostDto)}
     */
    @Test
    void testUpdatePost() {
        PostEntity postEntity = new PostEntity();
        postEntity.setAuthorId(123L);
        postEntity.setCategory(Category.GAMES);
        postEntity.setDescription("The characteristics of someone or something");
        postEntity.setEmailAddress("42 Main St");
        postEntity.setId(123L);
        postEntity.setImage(new HashSet<>());
        postEntity.setLocalization("Localization");
        postEntity.setPhoneNumber("4105551212");
        postEntity.setPrice(1L);
        postEntity.setPromoted(true);
        postEntity.setTitle("Dr");
        when(postRepository.save((PostEntity) any())).thenReturn(postEntity);

        PostEntity postEntity1 = new PostEntity();
        postEntity1.setAuthorId(123L);
        postEntity1.setCategory(Category.GAMES);
        postEntity1.setDescription("The characteristics of someone or something");
        postEntity1.setEmailAddress("42 Main St");
        postEntity1.setId(123L);
        postEntity1.setImage(new HashSet<>());
        postEntity1.setLocalization("Localization");
        postEntity1.setPhoneNumber("4105551212");
        postEntity1.setPrice(1L);
        postEntity1.setPromoted(true);
        postEntity1.setTitle("Dr");
        when(postMapper.dtoToEntity((PostDto) any())).thenReturn(postEntity1);
        PostDto postDto = new PostDto();
        postServiceImpl.updatePost(postDto);
        verify(postRepository).save((PostEntity) any());
        verify(postMapper).dtoToEntity((PostDto) any());
        assertFalse(postDto.isPromoted());
    }

    /**
     * Method under test: {@link PostServiceImpl#getPostById(Long)}
     */
    @Test
    void testGetPostById() {
        PostEntity postEntity = new PostEntity();
        postEntity.setAuthorId(123L);
        postEntity.setCategory(Category.GAMES);
        postEntity.setDescription("The characteristics of someone or something");
        postEntity.setEmailAddress("42 Main St");
        postEntity.setId(123L);
        postEntity.setImage(new HashSet<>());
        postEntity.setLocalization("Localization");
        postEntity.setPhoneNumber("4105551212");
        postEntity.setPrice(1L);
        postEntity.setPromoted(true);
        postEntity.setTitle("Dr");
        when(postRepository.getById((Long) any())).thenReturn(postEntity);
        PostDto postDto = new PostDto();
        when(postMapper.entityToDto((PostEntity) any())).thenReturn(postDto);
        assertSame(postDto, postServiceImpl.getPostById(123L));
        verify(postRepository).getById((Long) any());
        verify(postMapper).entityToDto((PostEntity) any());
    }

    /**
     * Method under test: {@link PostServiceImpl#getAllPosts()}
     */
    @Test
    void testGetAllPosts() {
        when(postRepository.findAll()).thenReturn(new ArrayList<>());
        assertTrue(postServiceImpl.getAllPosts().isEmpty());
        verify(postRepository).findAll();
    }

    /**
     * Method under test: {@link PostServiceImpl#getPostsByAuthorId(Long)}
     */
    @Test
    void testGetPostsByAuthorId() {
        when(postRepository.findAllByAuthorId((Long) any())).thenReturn(new ArrayList<>());
        assertTrue(postServiceImpl.getPostsByAuthorId(123L).isEmpty());
        verify(postRepository).findAllByAuthorId((Long) any());
    }

    /**
     * Method under test: {@link PostServiceImpl#getPostsByLocalization(String)}
     */
    @Test
    void testGetPostsByLocalization() {
        when(postRepository.findAllByLocalization((String) any())).thenReturn(new ArrayList<>());
        assertTrue(postServiceImpl.getPostsByLocalization("Localization").isEmpty());
        verify(postRepository).findAllByLocalization((String) any());
    }

    /**
     * Method under test: {@link PostServiceImpl#getPostsByCategory(Category)}
     */
    @Test
    void testGetPostsByCategory() {
        when(postRepository.findAllByCategory((Category) any())).thenReturn(new ArrayList<>());
        assertTrue(postServiceImpl.getPostsByCategory(Category.GAMES).isEmpty());
        verify(postRepository).findAllByCategory((Category) any());
    }

    /**
     * Method under test: {@link PostServiceImpl#getPostsByCategory(Category)}
     */
    @Test
    void testGetPostsByCategory2() {
        when(postRepository.findAllByCategory((Category) any())).thenReturn(new ArrayList<>());
        assertTrue(postServiceImpl.getPostsByCategory(Category.LAPTOPS).isEmpty());
        verify(postRepository).findAllByCategory((Category) any());
    }
}

