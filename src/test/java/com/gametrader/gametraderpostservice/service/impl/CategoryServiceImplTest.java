package com.gametrader.gametraderpostservice.service.impl;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.gametrader.gametraderpostservice.mapper.CategoryMapper;
import com.gametrader.gametraderpostservice.repository.CategoryRepository;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {CategoryServiceImpl.class})
@ExtendWith(SpringExtension.class)
class CategoryServiceImplTest {
    @MockBean
    private CategoryMapper categoryMapper;

    @MockBean
    private CategoryRepository categoryRepository;

    @Autowired
    private CategoryServiceImpl categoryServiceImpl;

    /**
     * Method under test: {@link CategoryServiceImpl#getAllCategories()}
     */
    @Test
    void testGetAllCategories() {
        when(categoryRepository.findAll()).thenReturn(new ArrayList<>());
        assertTrue(categoryServiceImpl.getAllCategories().isEmpty());
        verify(categoryRepository).findAll();
    }
}

