package com.gametrader.gametraderpostservice.controller;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gametrader.gametraderpostservice.dto.CategoryDto;
import com.gametrader.gametraderpostservice.dto.PostDto;
import com.gametrader.gametraderpostservice.service.PostService;

import java.util.ArrayList;

import java.util.HashSet;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
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
     * Method under test: {@link PostController#createPost(PostDto)}
     */
    @Test
    void testCreatePost() throws Exception {
        doNothing().when(postService).createPost((PostDto) any());

        PostDto postDto = new PostDto();
        postDto.setAuthorId(123L);
        postDto.setCategory(new CategoryDto());
        postDto.setDescription("The characteristics of someone or something");
        postDto.setEmailAddress("42 Main St");
        postDto.setId(123L);
        postDto.setImage(new HashSet<>());
        postDto.setLocalization("Localization");
        postDto.setPhoneNumber("4105551212");
        postDto.setPrice(1L);
        postDto.setPromoted(true);
        postDto.setTitle("Dr");
        String content = (new ObjectMapper()).writeValueAsString(postDto);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/v1/post/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(postController).build().perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isCreated());
    }

    /**
     * Method under test: {@link PostController#updatePost(PostDto)}
     */
    @Test
    void testUpdatePost() throws Exception {
        doNothing().when(postService).updatePost((PostDto) any());

        PostDto postDto = new PostDto();
        postDto.setAuthorId(123L);
        postDto.setCategory(new CategoryDto());
        postDto.setDescription("The characteristics of someone or something");
        postDto.setEmailAddress("42 Main St");
        postDto.setId(123L);
        postDto.setImage(new HashSet<>());
        postDto.setLocalization("Localization");
        postDto.setPhoneNumber("4105551212");
        postDto.setPrice(1L);
        postDto.setPromoted(true);
        postDto.setTitle("Dr");
        String content = (new ObjectMapper()).writeValueAsString(postDto);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.put("/v1/post/update/{id}", 123L)
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(postController).build().perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isAccepted());
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
    void testGetAllPostsByAuthorId2() throws Exception {
        when(postService.getAllPosts()).thenReturn(new ArrayList<>());
        when(postService.getPostsByAuthorId((Long) any())).thenReturn(new ArrayList<>());
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
     * Method under test: {@link PostController#getAllPostsByAuthorId(Long)}
     */
    @Test
    void testGetAllPostsByAuthorId() throws Exception {
        when(postService.getPostsByAuthorId((Long) any())).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/v1/post/get/all/{authorId}", 123L);
        MockMvcBuilders.standaloneSetup(postController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link PostController#getAllPostsByCategory(Long)}
     */
    @Test
    void testGetAllPostsByCategory() throws Exception {
        when(postService.getPostsByCategory((Long) any())).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/v1/post/get/all/category/{categoryId}",
                123L);
        MockMvcBuilders.standaloneSetup(postController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link PostController#getAllPostsByCategory(Long)}
     */
    @Test
    void testGetAllPostsByCategory2() throws Exception {
        when(postService.getPostsByCategory((Long) any())).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/v1/post/get/all/category/{categoryId}",
                123L);
        getResult.characterEncoding("Encoding");
        MockMvcBuilders.standaloneSetup(postController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link PostController#getAllPostsByCategory(Long, String)}
     */
    @Test
    void testGetAllPostsByCategory3() throws Exception {
        when(postService.getPostsByCategoryAndLocalization((Long) any(), (String) any())).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/v1/post/get/all/category-and-localization/{categoryId}/{localization}", 123L, "Localization");
        MockMvcBuilders.standaloneSetup(postController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link PostController#getAllPostsByCategory(Long, String)}
     */
    @Test
    void testGetAllPostsByCategory4() throws Exception {
        when(postService.getPostsByCategoryAndLocalization((Long) any(), (String) any())).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders
                .get("/v1/post/get/all/category-and-localization/{categoryId}/{localization}", 123L, "Localization");
        getResult.characterEncoding("Encoding");
        MockMvcBuilders.standaloneSetup(postController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link PostController#getAllPostsByLocalization(String)}
     */
    @Test
    void testGetAllPostsByLocalization() throws Exception {
        when(postService.getPostsByLocalization((String) any())).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/v1/post/get/all/localization{localization}", "Localization");
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
    void testGetAllPostsByLocalization2() throws Exception {
        when(postService.getPostsByLocalization((String) any())).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/v1/post/get/all/localization{localization}",
                "Localization");
        getResult.characterEncoding("Encoding");
        MockMvcBuilders.standaloneSetup(postController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }
}

