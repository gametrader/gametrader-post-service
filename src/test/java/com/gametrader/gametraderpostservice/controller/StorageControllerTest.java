package com.gametrader.gametraderpostservice.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gametrader.gametraderpostservice.service.StorageService;

import java.util.HashSet;
import java.util.Set;

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

@ContextConfiguration(classes = {StorageController.class})
@ExtendWith(SpringExtension.class)
class StorageControllerTest {
    @Autowired
    private StorageController storageController;

    @MockBean
    private StorageService storageService;

    /**
     * Method under test: {@link StorageController#addImages(Set)}
     */
    @Test
    void testAddImages() throws Exception {
        MockHttpServletRequestBuilder postResult = MockMvcRequestBuilders.post("/v1/post/storage/add");
        MockHttpServletRequestBuilder requestBuilder = postResult.param("files", String.valueOf(new HashSet<>()));
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(storageController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(415));
    }

    /**
     * Method under test: {@link StorageController#getImages(Set)}
     */
    @Test
    void testGetImages() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.get("/v1/post/storage/get")
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult
                .content(objectMapper.writeValueAsString(new HashSet<>()));
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(storageController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(500));
    }
}

