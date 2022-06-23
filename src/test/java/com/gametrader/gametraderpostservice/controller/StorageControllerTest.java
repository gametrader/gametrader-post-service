package com.gametrader.gametraderpostservice.controller;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

import com.gametrader.gametraderpostservice.service.StorageService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.multipart.MultipartFile;

@ContextConfiguration(classes = {StorageController.class})
@ExtendWith(SpringExtension.class)
class StorageControllerTest {
    @Autowired
    private StorageController storageController;

    @MockBean
    private StorageService storageService;

    /**
     * Method under test: {@link StorageController#addImages(MultipartFile[])}
     */
    @Test
    void testAddImages() throws Exception {
        MockHttpServletRequestBuilder postResult = MockMvcRequestBuilders.post("/v1/post/storage/add");
        MockHttpServletRequestBuilder requestBuilder = postResult.param("files", String.valueOf(new MultipartFile[]{null}));
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(storageController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(415));
    }

    /**
     * Method under test: {@link StorageController#getImages(String)}
     */
    @Test
    void testGetImages() throws Exception {
        when(storageService.downloadFile((String) any())).thenReturn("AAAAAAAA".getBytes("UTF-8"));
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/v1/post/storage/get/{imageName}",
                "Image Name");
        MockMvcBuilders.standaloneSetup(storageController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/octet-stream"))
                .andExpect(MockMvcResultMatchers.content().string("AAAAAAAA"));
    }
}

