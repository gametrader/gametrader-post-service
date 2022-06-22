package com.gametrader.gametraderpostservice.service;


import com.gametrader.gametraderpostservice.entity.CategoryEntity;
import com.gametrader.gametraderpostservice.repository.CategoryEntityRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoryService {

  private final CategoryEntityRepository categoryRepository;


  public List<CategoryEntity> getAll() {
    return categoryRepository.findAll();
  }
}
