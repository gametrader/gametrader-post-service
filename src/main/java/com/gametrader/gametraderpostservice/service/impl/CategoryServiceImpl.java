package com.gametrader.gametraderpostservice.service.impl;

import com.gametrader.gametraderpostservice.dto.CategoryDto;
import com.gametrader.gametraderpostservice.mapper.CategoryMapper;
import com.gametrader.gametraderpostservice.repository.CategoryRepository;
import com.gametrader.gametraderpostservice.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    @Override
    public List<CategoryDto> getAllCategories() {
        return categoryRepository.findAll()
                .stream()
                .map(categoryMapper::entityToDto)
                .collect(Collectors.toList());
    }
}
