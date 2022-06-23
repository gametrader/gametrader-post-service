package com.gametrader.gametraderpostservice.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.gametrader.gametraderpostservice.dto.CategoryDto;
import com.gametrader.gametraderpostservice.dto.PostDto;
import com.gametrader.gametraderpostservice.entity.CategoryEntity;
import com.gametrader.gametraderpostservice.entity.ImageEntity;
import com.gametrader.gametraderpostservice.entity.PostEntity;
import com.gametrader.gametraderpostservice.mapper.PostMapperImpl;
import com.gametrader.gametraderpostservice.repository.ImageRepository;
import com.gametrader.gametraderpostservice.repository.PostRepository;
import com.gametrader.gametraderpostservice.service.PostService;
import com.gametrader.gametraderpostservice.service.impl.PostServiceImpl;

import java.util.ArrayList;
import java.util.HashSet;

import org.junit.jupiter.api.Disabled;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {PostController.class})
@ExtendWith(SpringExtension.class)
class PostControllerTest {
    @Autowired
    private PostController postController;

    @MockBean
    private PostService postService;

    /**
     * Method under test: {@link PostController#createPost(PostDto)}
     */
    @Test
    void testCreatePost() {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R008 Failed to instantiate class under test.
        //   Diffblue Cover was unable to construct an instance of PostController.
        //   Ensure there is a package-visible constructor or factory method that does not
        //   throw for the class under test.
        //   If such a method is already present but Diffblue Cover does not find it, it can
        //   be specified using custom rules for inputs:
        //   https://docs.diffblue.com/knowledge-base/cli/custom-inputs/
        //   This can happen because the factory method takes arguments, throws, returns null
        //   or returns a subtype.
        //   See https://diff.blue/R008 for further troubleshooting of this issue.

        CategoryEntity categoryEntity = new CategoryEntity();
        categoryEntity.setIconName("Icon Name");
        categoryEntity.setId(123L);
        categoryEntity.setName("Name");

        PostEntity postEntity = new PostEntity();
        postEntity.setAuthorId(123L);
        postEntity.setCategory(categoryEntity);
        postEntity.setDescription("The characteristics of someone or something");
        postEntity.setEmailAddress("42 Main St");
        postEntity.setId(123L);
        postEntity.setImage(new HashSet<>());
        postEntity.setLocalization("Localization");
        postEntity.setPhoneNumber("4105551212");
        postEntity.setPrice(1L);
        postEntity.setPromoted(true);
        postEntity.setTitle("Dr");
        PostRepository postRepository = mock(PostRepository.class);
        when(postRepository.save((PostEntity) any())).thenReturn(postEntity);
        ImageRepository imageRepository = mock(ImageRepository.class);
        when(imageRepository.saveAll((Iterable<ImageEntity>) any())).thenReturn(new ArrayList<>());
        PostController postController = new PostController(
                new PostServiceImpl(postRepository, imageRepository, new PostMapperImpl()));
        ResponseEntity<Void> actualCreatePostResult = postController.createPost(new PostDto());
        assertNull(actualCreatePostResult.getBody());
        assertEquals(HttpStatus.CREATED, actualCreatePostResult.getStatusCode());
        assertTrue(actualCreatePostResult.getHeaders().isEmpty());
        verify(postRepository).save((PostEntity) any());
        verify(imageRepository).saveAll((Iterable<ImageEntity>) any());
    }

    /**
     * Method under test: {@link PostController#createPost(PostDto)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testCreatePost2() {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R008 Failed to instantiate class under test.
        //   Diffblue Cover was unable to construct an instance of PostController.
        //   Ensure there is a package-visible constructor or factory method that does not
        //   throw for the class under test.
        //   If such a method is already present but Diffblue Cover does not find it, it can
        //   be specified using custom rules for inputs:
        //   https://docs.diffblue.com/knowledge-base/cli/custom-inputs/
        //   This can happen because the factory method takes arguments, throws, returns null
        //   or returns a subtype.
        //   See https://diff.blue/R008 for further troubleshooting of this issue.

        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at com.gametrader.gametraderpostservice.service.impl.PostServiceImpl.createPost(PostServiceImpl.java:25)
        //       at com.gametrader.gametraderpostservice.controller.PostController.createPost(PostController.java:25)
        //   In order to prevent createPost(PostDto)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   createPost(PostDto).
        //   See https://diff.blue/R013 to resolve this issue.

        CategoryEntity categoryEntity = new CategoryEntity();
        categoryEntity.setIconName("Icon Name");
        categoryEntity.setId(123L);
        categoryEntity.setName("Name");

        PostEntity postEntity = new PostEntity();
        postEntity.setAuthorId(123L);
        postEntity.setCategory(categoryEntity);
        postEntity.setDescription("The characteristics of someone or something");
        postEntity.setEmailAddress("42 Main St");
        postEntity.setId(123L);
        postEntity.setImage(new HashSet<>());
        postEntity.setLocalization("Localization");
        postEntity.setPhoneNumber("4105551212");
        postEntity.setPrice(1L);
        postEntity.setPromoted(true);
        postEntity.setTitle("Dr");
        PostRepository postRepository = mock(PostRepository.class);
        when(postRepository.save((PostEntity) any())).thenReturn(postEntity);
        ImageRepository imageRepository = mock(ImageRepository.class);
        when(imageRepository.saveAll((Iterable<ImageEntity>) any())).thenReturn(new ArrayList<>());
        PostController postController = new PostController(new PostServiceImpl(postRepository, imageRepository, null));
        postController.createPost(new PostDto());
    }

    /**
     * Method under test: {@link PostController#updatePost(PostDto)}
     */
    @Test
    void testUpdatePost() {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R008 Failed to instantiate class under test.
        //   Diffblue Cover was unable to construct an instance of PostController.
        //   Ensure there is a package-visible constructor or factory method that does not
        //   throw for the class under test.
        //   If such a method is already present but Diffblue Cover does not find it, it can
        //   be specified using custom rules for inputs:
        //   https://docs.diffblue.com/knowledge-base/cli/custom-inputs/
        //   This can happen because the factory method takes arguments, throws, returns null
        //   or returns a subtype.
        //   See https://diff.blue/R008 for further troubleshooting of this issue.

        CategoryEntity categoryEntity = new CategoryEntity();
        categoryEntity.setIconName("Icon Name");
        categoryEntity.setId(123L);
        categoryEntity.setName("Name");

        PostEntity postEntity = new PostEntity();
        postEntity.setAuthorId(123L);
        postEntity.setCategory(categoryEntity);
        postEntity.setDescription("The characteristics of someone or something");
        postEntity.setEmailAddress("42 Main St");
        postEntity.setId(123L);
        postEntity.setImage(new HashSet<>());
        postEntity.setLocalization("Localization");
        postEntity.setPhoneNumber("4105551212");
        postEntity.setPrice(1L);
        postEntity.setPromoted(true);
        postEntity.setTitle("Dr");
        PostRepository postRepository = mock(PostRepository.class);
        when(postRepository.save((PostEntity) any())).thenReturn(postEntity);
        ImageRepository imageRepository = mock(ImageRepository.class);
        when(imageRepository.saveAll((Iterable<ImageEntity>) any())).thenReturn(new ArrayList<>());
        PostController postController = new PostController(
                new PostServiceImpl(postRepository, imageRepository, new PostMapperImpl()));
        ResponseEntity<Void> actualUpdatePostResult = postController.updatePost(new PostDto());
        assertNull(actualUpdatePostResult.getBody());
        assertEquals(HttpStatus.ACCEPTED, actualUpdatePostResult.getStatusCode());
        assertTrue(actualUpdatePostResult.getHeaders().isEmpty());
        verify(postRepository).save((PostEntity) any());
        verify(imageRepository).saveAll((Iterable<ImageEntity>) any());
    }

    /**
     * Method under test: {@link PostController#updatePost(PostDto)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testUpdatePost2() {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R008 Failed to instantiate class under test.
        //   Diffblue Cover was unable to construct an instance of PostController.
        //   Ensure there is a package-visible constructor or factory method that does not
        //   throw for the class under test.
        //   If such a method is already present but Diffblue Cover does not find it, it can
        //   be specified using custom rules for inputs:
        //   https://docs.diffblue.com/knowledge-base/cli/custom-inputs/
        //   This can happen because the factory method takes arguments, throws, returns null
        //   or returns a subtype.
        //   See https://diff.blue/R008 for further troubleshooting of this issue.

        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at com.gametrader.gametraderpostservice.service.impl.PostServiceImpl.updatePost(PostServiceImpl.java:32)
        //       at com.gametrader.gametraderpostservice.controller.PostController.updatePost(PostController.java:31)
        //   In order to prevent updatePost(PostDto)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   updatePost(PostDto).
        //   See https://diff.blue/R013 to resolve this issue.

        CategoryEntity categoryEntity = new CategoryEntity();
        categoryEntity.setIconName("Icon Name");
        categoryEntity.setId(123L);
        categoryEntity.setName("Name");

        PostEntity postEntity = new PostEntity();
        postEntity.setAuthorId(123L);
        postEntity.setCategory(categoryEntity);
        postEntity.setDescription("The characteristics of someone or something");
        postEntity.setEmailAddress("42 Main St");
        postEntity.setId(123L);
        postEntity.setImage(new HashSet<>());
        postEntity.setLocalization("Localization");
        postEntity.setPhoneNumber("4105551212");
        postEntity.setPrice(1L);
        postEntity.setPromoted(true);
        postEntity.setTitle("Dr");
        PostRepository postRepository = mock(PostRepository.class);
        when(postRepository.save((PostEntity) any())).thenReturn(postEntity);
        ImageRepository imageRepository = mock(ImageRepository.class);
        when(imageRepository.saveAll((Iterable<ImageEntity>) any())).thenReturn(new ArrayList<>());
        PostController postController = new PostController(new PostServiceImpl(postRepository, imageRepository, null));
        postController.updatePost(new PostDto());
    }

    /**
     * Method under test: {@link PostController#getPostById(Long)}
     */
    @Test
    void testGetPostById() throws Exception {
        when(postService.getPostById((Long) any())).thenReturn(new PostDto());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/v1/post/get/{id}", 123L);
        MockMvcBuilders.standaloneSetup(postController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"id\":null,\"authorId\":null,\"title\":null,\"category\":null,\"description\":null,\"localization\":null,"
                                        + "\"emailAddress\":null,\"phoneNumber\":null,\"price\":null,\"image\":null,\"promoted\":false}"));
    }

    /**
     * Method under test: {@link PostController#getAllPosts()}
     */
    @Test
    void testGetAllPosts() throws Exception {
        when(postService.getAllPosts()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/v1/post/get/all");
        MockMvcBuilders.standaloneSetup(postController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link PostController#getAllPosts()}
     */
    @Test
    void testGetAllPosts2() throws Exception {
        when(postService.getAllPosts()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/v1/post/get/all");
        getResult.characterEncoding("Encoding");
        MockMvcBuilders.standaloneSetup(postController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link PostController#getAllPostsByAuthorId(Long)}
     */
    @Test
    void testGetAllPostsByAuthorId() throws Exception {
        when(postService.getAllPosts()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/v1/post/get/all/{authorId}", "",
                "Uri Vars");
        MockMvcBuilders.standaloneSetup(postController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link PostController#getAllPostsByCategory(CategoryDto)}
     */
    @Test
    void testGetAllPostsByCategory() throws Exception {
        when(postService.getAllPosts()).thenReturn(new ArrayList<>());
        new CategoryDto();
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/v1/post/get/all/{category}", "",
                "Uri Vars");
        MockMvcBuilders.standaloneSetup(postController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link PostController#getAllPostsByLocalization(String)}
     */
    @Test
    void testGetAllPostsByLocalization() throws Exception {
        when(postService.getAllPosts()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/v1/post/get/all/{localization}", "",
                "Uri Vars");
        MockMvcBuilders.standaloneSetup(postController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }
}

