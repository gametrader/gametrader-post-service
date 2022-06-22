package com.gametrader.gametraderpostservice.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.amazonaws.services.s3.AmazonS3Client;
import com.gametrader.gametraderpostservice.dto.PostDto;
import com.gametrader.gametraderpostservice.entity.PostEntity;
import com.gametrader.gametraderpostservice.mapper.PostMapperImpl;
import com.gametrader.gametraderpostservice.model.Category;
import com.gametrader.gametraderpostservice.repository.PostRepository;
import com.gametrader.gametraderpostservice.service.PostService;
import com.gametrader.gametraderpostservice.service.impl.PostServiceImpl;
import com.gametrader.gametraderpostservice.service.impl.StorageServiceImpl;
import com.sun.security.auth.UserPrincipal;

import java.util.ArrayList;

import java.util.HashSet;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.ResultActions;
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
     * Method under test: {@link PostController#createPost(PostDto, java.util.Set)}
     */
    @Test
    void testCreatePost() {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R008 Failed to instantiate class under test.
        //   Diffblue Cover was unable to construct an instance of PostController.
        //   Add a package-visible constructor or a factory method for the class under test.
        //   If such a method is already present but Diffblue Cover does not find it, it can
        //   be specified using custom rules for inputs:
        //   https://docs.diffblue.com/knowledge-base/cli/custom-inputs/
        //   This can happen because the factory method takes arguments, throws, returns null
        //   or returns a subtype.
        //   See https://diff.blue/R008

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
        PostRepository postRepository = mock(PostRepository.class);
        when(postRepository.save((PostEntity) any())).thenReturn(postEntity);
        PostMapperImpl postMapper = new PostMapperImpl();
        PostController postController = new PostController(
                new PostServiceImpl(postRepository, postMapper, new StorageServiceImpl(new AmazonS3Client())));
        PostDto dto = mock(PostDto.class);
        ResponseEntity<Void> actualCreatePostResult = postController.createPost(dto, new HashSet<>());
        assertNull(actualCreatePostResult.getBody());
        assertEquals(HttpStatus.CREATED, actualCreatePostResult.getStatusCode());
        assertTrue(actualCreatePostResult.getHeaders().isEmpty());
        verify(postRepository).save((PostEntity) any());
    }


    @Test
    void testUpdatePost() {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R008 Failed to instantiate class under test.
        //   Diffblue Cover was unable to construct an instance of PostController.
        //   Add a package-visible constructor or a factory method for the class under test.
        //   If such a method is already present but Diffblue Cover does not find it, it can
        //   be specified using custom rules for inputs:
        //   https://docs.diffblue.com/knowledge-base/cli/custom-inputs/
        //   This can happen because the factory method takes arguments, throws, returns null
        //   or returns a subtype.
        //   See https://diff.blue/R008

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
        PostRepository postRepository = mock(PostRepository.class);
        when(postRepository.save((PostEntity) any())).thenReturn(postEntity1);
        when(postRepository.getById((Long) any())).thenReturn(postEntity);
        PostMapperImpl postMapper = new PostMapperImpl();
        PostController postController = new PostController(
                new PostServiceImpl(postRepository, postMapper, new StorageServiceImpl(new AmazonS3Client())));
        PostDto dto = mock(PostDto.class);
        ResponseEntity<Void> actualUpdatePostResult = postController.updatePost(dto, new HashSet<>());
        assertNull(actualUpdatePostResult.getBody());
        assertEquals(HttpStatus.ACCEPTED, actualUpdatePostResult.getStatusCode());
        assertTrue(actualUpdatePostResult.getHeaders().isEmpty());
        verify(postRepository).getById((Long) any());
        verify(postRepository).save((PostEntity) any());
    }

    /**
     * Method under test: {@link PostController#getPostById(Long)}
     */
    @Test
    void testGetPostById() throws Exception {
        when(this.postService.getPostById((Long) any())).thenReturn(mock(PostDto.class));
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/v1/post/get/{id}", "Uri Vars",
                "Uri Vars");
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.postController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(400));
    }

    /**
     * Method under test: {@link PostController#getPostById(Long)}
     */
    @Test
    void testGetPostById2() throws Exception {
        when(this.postService.getPostById((Long) any())).thenReturn(mock(PostDto.class));
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/v1/post/get/{id}", 123L);
        getResult.accept("https://example.org/example");
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.postController).build().perform(getResult);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(406));
    }

    /**
     * Method under test: {@link PostController#getAllPosts()}
     */
    @Test
    void testGetAllPosts() throws Exception {
        when(this.postService.getAllPosts()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/v1/post/get/all");
        MockMvcBuilders.standaloneSetup(this.postController)
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
        when(this.postService.getAllPosts()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/v1/post/get/all");
        getResult.contentType("https://example.org/example");
        MockMvcBuilders.standaloneSetup(this.postController)
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
        when(this.postService.getAllPosts()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/v1/post/get/all/{authorId}", "",
                "Uri Vars");
        MockMvcBuilders.standaloneSetup(this.postController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link PostController#getAllPostsByAuthorId(Long)}
     */
    @Test
    void testGetAllPostsByAuthorId2() throws Exception {
        when(this.postService.getAllPosts()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/v1/post/get/all/{authorId}", "", "Uri Vars");
        getResult.contentType("https://example.org/example");
        MockMvcBuilders.standaloneSetup(this.postController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link PostController#getAllPostsByCategory(Category)}
     */
    @Test
    void testGetAllPostsByCategory() throws Exception {
        when(this.postService.getAllPosts()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/v1/post/get/all/{category}", "",
                "Uri Vars");
        MockMvcBuilders.standaloneSetup(this.postController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link PostController#getAllPostsByCategory(Category)}
     */
    @Test
    void testGetAllPostsByCategory2() throws Exception {
        when(this.postService.getAllPosts()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/v1/post/get/all/{category}", "", "?");
        MockMvcBuilders.standaloneSetup(this.postController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link PostController#getAllPostsByCategory(Category)}
     */
    @Test
    void testGetAllPostsByCategory3() throws Exception {
        when(this.postService.getAllPosts()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/v1/post/get/all/{category}", "", "U");
        MockMvcBuilders.standaloneSetup(this.postController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link PostController#getAllPostsByCategory(Category)}
     */
    @Test
    void testGetAllPostsByCategory4() throws Exception {
        when(this.postService.getAllPosts()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/v1/post/get/all/{category}", "", 42);
        MockMvcBuilders.standaloneSetup(this.postController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link PostController#getAllPostsByCategory(Category)}
     */
    @Test
    void testGetAllPostsByCategory5() throws Exception {
        when(this.postService.getAllPosts()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/v1/post/get/all/{category}", "", 1);
        MockMvcBuilders.standaloneSetup(this.postController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link PostController#getAllPostsByCategory(Category)}
     */
    @Test
    void testGetAllPostsByCategory6() throws Exception {
        when(this.postService.getAllPosts()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/v1/post/get/all/{category}", "", 0);
        MockMvcBuilders.standaloneSetup(this.postController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link PostController#getAllPostsByCategory(Category)}
     */
    @Test
    void testGetAllPostsByCategory7() throws Exception {
        when(this.postService.getAllPosts()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/v1/post/get/all/{category}", "", -1);
        MockMvcBuilders.standaloneSetup(this.postController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link PostController#getAllPostsByCategory(Category)}
     */
    @Test
    void testGetAllPostsByCategory8() throws Exception {
        when(this.postService.getAllPosts()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/v1/post/get/all/{category}", "",
                Integer.MIN_VALUE);
        MockMvcBuilders.standaloneSetup(this.postController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link PostController#getAllPostsByCategory(Category)}
     */
    @Test
    void testGetAllPostsByCategory9() throws Exception {
        when(this.postService.getAllPosts()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/v1/post/get/all/{category}", "", "42");
        MockMvcBuilders.standaloneSetup(this.postController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link PostController#getAllPostsByCategory(Category)}
     */
    @Test
    void testGetAllPostsByCategory10() throws Exception {
        when(this.postService.getAllPosts()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/v1/post/get/all/{category}", "", "");
        MockMvcBuilders.standaloneSetup(this.postController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link PostController#getAllPostsByCategory(Category)}
     */
    @Test
    void testGetAllPostsByCategory11() throws Exception {
        when(this.postService.getAllPosts()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/v1/post/get/all/{category}", "", "Uri Vars");
        getResult.secure(true);
        MockMvcBuilders.standaloneSetup(this.postController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link PostController#getAllPostsByCategory(Category)}
     */
    @Test
    void testGetAllPostsByCategory12() throws Exception {
        when(this.postService.getAllPosts()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/v1/post/get/all/{category}", "", "Uri Vars");
        getResult.content("AAAAAAAA".getBytes("UTF-8"));
        MockMvcBuilders.standaloneSetup(this.postController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link PostController#getAllPostsByCategory(Category)}
     */
    @Test
    void testGetAllPostsByCategory13() throws Exception {
        when(this.postService.getAllPosts()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/v1/post/get/all/{category}", "", "Uri Vars");
        getResult.content("https://example.org/example");
        MockMvcBuilders.standaloneSetup(this.postController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link PostController#getAllPostsByCategory(Category)}
     */
    @Test
    void testGetAllPostsByCategory14() throws Exception {
        when(this.postService.getAllPosts()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/v1/post/get/all/{category}", "", "Uri Vars");
        getResult.contentType("https://example.org/example");
        MockMvcBuilders.standaloneSetup(this.postController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link PostController#getAllPostsByCategory(Category)}
     */
    @Test
    void testGetAllPostsByCategory15() throws Exception {
        when(this.postService.getAllPosts()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/v1/post/get/all/{category}", "", "Uri Vars");
        getResult.accept("https://example.org/example");
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.postController).build().perform(getResult);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(406));
    }

    /**
     * Method under test: {@link PostController#getAllPostsByCategory(Category)}
     */
    @Test
    void testGetAllPostsByCategory16() throws Exception {
        when(this.postService.getAllPosts()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/v1/post/get/all/{category}", "", "Uri Vars");
        getResult.session(new MockHttpSession());
        MockMvcBuilders.standaloneSetup(this.postController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link PostController#getAllPostsByCategory(Category)}
     */
    @Test
    void testGetAllPostsByCategory17() throws Exception {
        when(this.postService.getAllPosts()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/v1/post/get/all/{category}", "", "Uri Vars");
        getResult.principal(new UserPrincipal("principal"));
        MockMvcBuilders.standaloneSetup(this.postController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link PostController#getAllPostsByCategory(Category)}
     */
    @Test
    void testGetAllPostsByCategory18() throws Exception {
        ArrayList<PostDto> postDtoList = new ArrayList<>();
        postDtoList.addAll(new ArrayList<>());
        when(this.postService.getAllPosts()).thenReturn(postDtoList);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/v1/post/get/all/{category}", "",
                "Uri Vars");
        MockMvcBuilders.standaloneSetup(this.postController)
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
        when(this.postService.getAllPosts()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/v1/post/get/all/{localization}", "",
                "Uri Vars");
        MockMvcBuilders.standaloneSetup(this.postController)
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
    void testGetAllPostsByLocalization2() throws Exception {
        when(this.postService.getAllPosts()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/v1/post/get/all/{localization}", "",
                "Uri Vars");
        getResult.contentType("https://example.org/example");
        MockMvcBuilders.standaloneSetup(this.postController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }
}

