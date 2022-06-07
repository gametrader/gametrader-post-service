package com.gametrader.gametraderpostservice.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gametrader.gametraderpostservice.service.StorageService;

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

@ContextConfiguration(classes = {StorageController.class})
@ExtendWith(SpringExtension.class)
class StorageControllerTest {
    @Autowired
    private StorageController storageController;

    @MockBean
    private StorageService storageService;

    /**
     * Method under test: {@link StorageController#getImages(java.util.Set)}
     */
    @Test
    void testGetImages() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.get("/v1/post/storage/get")
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult
                .content(objectMapper.writeValueAsString(new HashSet<>()));
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.storageController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(500));
    }

    /**
     * Method under test: {@link StorageController#getImages(java.util.Set)}
     */
    @Test
    void testGetImages2() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.get("/v1/post/storage/get", "Uri Vars")
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult
                .content(objectMapper.writeValueAsString(new HashSet<>()));
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.storageController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(500));
    }
}

