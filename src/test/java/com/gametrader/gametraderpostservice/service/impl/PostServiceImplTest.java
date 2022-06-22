package com.gametrader.gametraderpostservice.service.impl;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.gametrader.gametraderpostservice.dto.PostDto;
import com.gametrader.gametraderpostservice.entity.ImageEntity;
import com.gametrader.gametraderpostservice.entity.PostEntity;
import com.gametrader.gametraderpostservice.mapper.PostMapper;
import com.gametrader.gametraderpostservice.model.Category;
import com.gametrader.gametraderpostservice.repository.PostRepository;
import com.gametrader.gametraderpostservice.service.StorageService;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import java.util.HashSet;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.multipart.MultipartFile;

@ContextConfiguration(classes = {PostServiceImpl.class})
@ExtendWith(SpringExtension.class)
class PostServiceImplTest {
    @MockBean
    private PostMapper postMapper;

    @MockBean
    private PostRepository postRepository;

    @Autowired
    private PostServiceImpl postServiceImpl;

    @MockBean
    private StorageService storageService;

    /**
     * Method under test: {@link PostServiceImpl#createPost(PostDto, java.util.Set)}
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
        postEntity.setTitle("Dr");
        when(this.postRepository.save((PostEntity) any())).thenReturn(postEntity);

        PostEntity postEntity1 = new PostEntity();
        postEntity1.setAuthorId(123L);
        postEntity1.setCategory(Category.GAMES);
        postEntity1.setDescription("The characteristics of someone or something");
        postEntity1.setEmailAddress("42 Main St");
        postEntity1.setId(123L);
        postEntity1.setImage(new HashSet<>());
        postEntity1.setLocalization("Localization");
        postEntity1.setPhoneNumber("4105551212");
        postEntity1.setTitle("Dr");
        when(this.postMapper.dtoToEntity((PostDto) any())).thenReturn(postEntity1);
        PostDto dto = mock(PostDto.class);
        this.postServiceImpl.createPost(dto, new HashSet<>());
        verify(this.postRepository).save((PostEntity) any());
        verify(this.postMapper).dtoToEntity((PostDto) any());
    }

    /**
     * Method under test: {@link PostServiceImpl#createPost(PostDto, java.util.Set)}
     */
    @Test
    void testCreatePost2() throws UnsupportedEncodingException {
        when(this.storageService.uploadFile((MultipartFile) any())).thenReturn("Upload File");

        PostEntity postEntity = new PostEntity();
        postEntity.setAuthorId(123L);
        postEntity.setCategory(Category.GAMES);
        postEntity.setDescription("The characteristics of someone or something");
        postEntity.setEmailAddress("42 Main St");
        postEntity.setId(123L);
        postEntity.setImage(new HashSet<>());
        postEntity.setLocalization("Localization");
        postEntity.setPhoneNumber("4105551212");
        postEntity.setTitle("Dr");
        when(this.postRepository.save((PostEntity) any())).thenReturn(postEntity);

        PostEntity postEntity1 = new PostEntity();
        postEntity1.setAuthorId(123L);
        postEntity1.setCategory(Category.GAMES);
        postEntity1.setDescription("The characteristics of someone or something");
        postEntity1.setEmailAddress("42 Main St");
        postEntity1.setId(123L);
        postEntity1.setImage(new HashSet<>());
        postEntity1.setLocalization("Localization");
        postEntity1.setPhoneNumber("4105551212");
        postEntity1.setTitle("Dr");
        when(this.postMapper.dtoToEntity((PostDto) any())).thenReturn(postEntity1);
        PostDto dto = mock(PostDto.class);

        HashSet<MultipartFile> multipartFileSet = new HashSet<>();
        multipartFileSet.add(new MockMultipartFile("Name", "AAAAAAAA".getBytes("UTF-8")));
        this.postServiceImpl.createPost(dto, multipartFileSet);
        verify(this.storageService).uploadFile((MultipartFile) any());
        verify(this.postRepository).save((PostEntity) any());
        verify(this.postMapper).dtoToEntity((PostDto) any());
    }

    /**
     * Method under test: {@link PostServiceImpl#updatePost(PostDto, Long, java.util.Set)}
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
        postEntity.setTitle("Dr");

        PostEntity postEntity1 = new PostEntity();
        postEntity1.setAuthorId(123L);
        postEntity1.setCategory(Category.GAMES);
        postEntity1.setDescription("The characteristics of someone or something");
        postEntity1.setEmailAddress("42 Main St");
        postEntity1.setId(123L);
        postEntity1.setImage(new HashSet<>());
        postEntity1.setLocalization("Localization");
        postEntity1.setPhoneNumber("4105551212");
        postEntity1.setTitle("Dr");
        when(this.postRepository.save((PostEntity) any())).thenReturn(postEntity1);
        when(this.postRepository.getById((Long) any())).thenReturn(postEntity);

        PostEntity postEntity2 = new PostEntity();
        postEntity2.setAuthorId(123L);
        postEntity2.setCategory(Category.GAMES);
        postEntity2.setDescription("The characteristics of someone or something");
        postEntity2.setEmailAddress("42 Main St");
        postEntity2.setId(123L);
        postEntity2.setImage(new HashSet<>());
        postEntity2.setLocalization("Localization");
        postEntity2.setPhoneNumber("4105551212");
        postEntity2.setTitle("Dr");
        when(this.postMapper.dtoToEntity((PostDto) any())).thenReturn(postEntity2);
        PostDto dto = mock(PostDto.class);
        this.postServiceImpl.updatePost(dto, new HashSet<>());
        verify(this.postRepository).getById((Long) any());
        verify(this.postRepository).save((PostEntity) any());
        verify(this.postMapper).dtoToEntity((PostDto) any());
    }

    /**
     * Method under test: {@link PostServiceImpl#updatePost(PostDto, Long, java.util.Set)}
     */
    @Test
    void testUpdatePost2() {
        when(this.storageService.deleteFile((String) any())).thenReturn("Delete File");

        ImageEntity image = new ImageEntity();
        image.setFileName("foo.txt");
        image.setId(123L);

        HashSet<ImageEntity> imageSet = new HashSet<>();
        imageSet.add(image);

        PostEntity postEntity = new PostEntity();
        postEntity.setAuthorId(123L);
        postEntity.setCategory(Category.GAMES);
        postEntity.setDescription("The characteristics of someone or something");
        postEntity.setEmailAddress("42 Main St");
        postEntity.setId(123L);
        postEntity.setImage(imageSet);
        postEntity.setLocalization("Localization");
        postEntity.setPhoneNumber("4105551212");
        postEntity.setTitle("Dr");

        PostEntity postEntity1 = new PostEntity();
        postEntity1.setAuthorId(123L);
        postEntity1.setCategory(Category.GAMES);
        postEntity1.setDescription("The characteristics of someone or something");
        postEntity1.setEmailAddress("42 Main St");
        postEntity1.setId(123L);
        postEntity1.setImage(new HashSet<>());
        postEntity1.setLocalization("Localization");
        postEntity1.setPhoneNumber("4105551212");
        postEntity1.setTitle("Dr");
        when(this.postRepository.save((PostEntity) any())).thenReturn(postEntity1);
        when(this.postRepository.getById((Long) any())).thenReturn(postEntity);

        PostEntity postEntity2 = new PostEntity();
        postEntity2.setAuthorId(123L);
        postEntity2.setCategory(Category.GAMES);
        postEntity2.setDescription("The characteristics of someone or something");
        postEntity2.setEmailAddress("42 Main St");
        postEntity2.setId(123L);
        postEntity2.setImage(new HashSet<>());
        postEntity2.setLocalization("Localization");
        postEntity2.setPhoneNumber("4105551212");
        postEntity2.setTitle("Dr");
        when(this.postMapper.dtoToEntity((PostDto) any())).thenReturn(postEntity2);
        PostDto dto = mock(PostDto.class);
        this.postServiceImpl.updatePost(dto,  new HashSet<>());
        verify(this.storageService).deleteFile((String) any());
        verify(this.postRepository).getById((Long) any());
        verify(this.postRepository).save((PostEntity) any());
        verify(this.postMapper).dtoToEntity((PostDto) any());
    }

    /**
     * Method under test: {@link PostServiceImpl#updatePost(PostDto, Long, java.util.Set)}
     */
    @Test
    void testUpdatePost3() {
        when(this.storageService.deleteFile((String) any())).thenReturn("Delete File");

        ImageEntity image = new ImageEntity();
        image.setFileName("foo.txt");
        image.setId(123L);

        ImageEntity image1 = new ImageEntity();
        image1.setFileName("foo.txt");
        image1.setId(123L);

        HashSet<ImageEntity> imageSet = new HashSet<>();
        imageSet.add(image1);
        imageSet.add(image);

        PostEntity postEntity = new PostEntity();
        postEntity.setAuthorId(123L);
        postEntity.setCategory(Category.GAMES);
        postEntity.setDescription("The characteristics of someone or something");
        postEntity.setEmailAddress("42 Main St");
        postEntity.setId(123L);
        postEntity.setImage(imageSet);
        postEntity.setLocalization("Localization");
        postEntity.setPhoneNumber("4105551212");
        postEntity.setTitle("Dr");

        PostEntity postEntity1 = new PostEntity();
        postEntity1.setAuthorId(123L);
        postEntity1.setCategory(Category.GAMES);
        postEntity1.setDescription("The characteristics of someone or something");
        postEntity1.setEmailAddress("42 Main St");
        postEntity1.setId(123L);
        postEntity1.setImage(new HashSet<>());
        postEntity1.setLocalization("Localization");
        postEntity1.setPhoneNumber("4105551212");
        postEntity1.setTitle("Dr");
        when(this.postRepository.save((PostEntity) any())).thenReturn(postEntity1);
        when(this.postRepository.getById((Long) any())).thenReturn(postEntity);

        PostEntity postEntity2 = new PostEntity();
        postEntity2.setAuthorId(123L);
        postEntity2.setCategory(Category.GAMES);
        postEntity2.setDescription("The characteristics of someone or something");
        postEntity2.setEmailAddress("42 Main St");
        postEntity2.setId(123L);
        postEntity2.setImage(new HashSet<>());
        postEntity2.setLocalization("Localization");
        postEntity2.setPhoneNumber("4105551212");
        postEntity2.setTitle("Dr");
        when(this.postMapper.dtoToEntity((PostDto) any())).thenReturn(postEntity2);
        PostDto dto = mock(PostDto.class);
        this.postServiceImpl.updatePost(dto,  new HashSet<>());
        verify(this.storageService, atLeast(1)).deleteFile((String) any());
        verify(this.postRepository).getById((Long) any());
        verify(this.postRepository).save((PostEntity) any());
        verify(this.postMapper).dtoToEntity((PostDto) any());
    }

    /**
     * Method under test: {@link PostServiceImpl#updatePost(PostDto, Long, java.util.Set)}
     */
    @Test
    void testUpdatePost4() {
        when(this.storageService.deleteFile((String) any())).thenReturn("Delete File");
        ImageEntity image = mock(ImageEntity.class);
        when(image.getFileName()).thenReturn("foo.txt");
        doNothing().when(image).setFileName((String) any());
        doNothing().when(image).setId((Long) any());
        image.setFileName("foo.txt");
        image.setId(123L);

        HashSet<ImageEntity> imageSet = new HashSet<>();
        imageSet.add(image);

        PostEntity postEntity = new PostEntity();
        postEntity.setAuthorId(123L);
        postEntity.setCategory(Category.GAMES);
        postEntity.setDescription("The characteristics of someone or something");
        postEntity.setEmailAddress("42 Main St");
        postEntity.setId(123L);
        postEntity.setImage(imageSet);
        postEntity.setLocalization("Localization");
        postEntity.setPhoneNumber("4105551212");
        postEntity.setTitle("Dr");

        PostEntity postEntity1 = new PostEntity();
        postEntity1.setAuthorId(123L);
        postEntity1.setCategory(Category.GAMES);
        postEntity1.setDescription("The characteristics of someone or something");
        postEntity1.setEmailAddress("42 Main St");
        postEntity1.setId(123L);
        postEntity1.setImage(new HashSet<>());
        postEntity1.setLocalization("Localization");
        postEntity1.setPhoneNumber("4105551212");
        postEntity1.setTitle("Dr");
        when(this.postRepository.save((PostEntity) any())).thenReturn(postEntity1);
        when(this.postRepository.getById((Long) any())).thenReturn(postEntity);

        PostEntity postEntity2 = new PostEntity();
        postEntity2.setAuthorId(123L);
        postEntity2.setCategory(Category.GAMES);
        postEntity2.setDescription("The characteristics of someone or something");
        postEntity2.setEmailAddress("42 Main St");
        postEntity2.setId(123L);
        postEntity2.setImage(new HashSet<>());
        postEntity2.setLocalization("Localization");
        postEntity2.setPhoneNumber("4105551212");
        postEntity2.setTitle("Dr");
        when(this.postMapper.dtoToEntity((PostDto) any())).thenReturn(postEntity2);
        PostDto dto = mock(PostDto.class);
        this.postServiceImpl.updatePost(dto,  new HashSet<>());
        verify(this.storageService).deleteFile((String) any());
        verify(this.postRepository).getById((Long) any());
        verify(this.postRepository).save((PostEntity) any());
        verify(image).getFileName();
        verify(image).setFileName((String) any());
        verify(image).setId((Long) any());
        verify(this.postMapper).dtoToEntity((PostDto) any());
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
        postEntity.setTitle("Dr");
        when(this.postRepository.getById((Long) any())).thenReturn(postEntity);
        when(this.postMapper.entityToDto((PostEntity) any())).thenReturn(mock(PostDto.class));
        this.postServiceImpl.getPostById(123L);
        verify(this.postRepository).getById((Long) any());
        verify(this.postMapper).entityToDto((PostEntity) any());
    }

    /**
     * Method under test: {@link PostServiceImpl#getAllPosts()}
     */
    @Test
    void testGetAllPosts() {
        when(this.postRepository.findAll()).thenReturn(new ArrayList<>());
        assertTrue(this.postServiceImpl.getAllPosts().isEmpty());
        verify(this.postRepository).findAll();
    }

    /**
     * Method under test: {@link PostServiceImpl#getPostsByAuthorId(Long)}
     */
    @Test
    void testGetPostsByAuthorId() {
        when(this.postRepository.findAllByAuthorId((Long) any())).thenReturn(new ArrayList<>());
        assertTrue(this.postServiceImpl.getPostsByAuthorId(123L).isEmpty());
        verify(this.postRepository).findAllByAuthorId((Long) any());
    }

    /**
     * Method under test: {@link PostServiceImpl#getPostsByLocalization(String)}
     */
    @Test
    void testGetPostsByLocalization() {
        when(this.postRepository.findAllByLocalization((String) any())).thenReturn(new ArrayList<>());
        assertTrue(this.postServiceImpl.getPostsByLocalization("Localization").isEmpty());
        verify(this.postRepository).findAllByLocalization((String) any());
    }

    /**
     * Method under test: {@link PostServiceImpl#getPostsByCategory(Category)}
     */
    @Test
    void testGetPostsByCategory() {
        when(this.postRepository.findAllByCategory((Category) any())).thenReturn(new ArrayList<>());
        assertTrue(this.postServiceImpl.getPostsByCategory(Category.GAMES).isEmpty());
        verify(this.postRepository).findAllByCategory((Category) any());
    }

    /**
     * Method under test: {@link PostServiceImpl#getPostsByCategory(Category)}
     */
    @Test
    void testGetPostsByCategory2() {
        when(this.postRepository.findAllByCategory((Category) any())).thenReturn(new ArrayList<>());
        assertTrue(this.postServiceImpl.getPostsByCategory(Category.LAPTOPS).isEmpty());
        verify(this.postRepository).findAllByCategory((Category) any());
    }
}

