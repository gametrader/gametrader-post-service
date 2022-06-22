package com.gametrader.gametraderpostservice.controller;

import com.gametrader.gametraderpostservice.entity.CategoryEntity;
import com.gametrader.gametraderpostservice.model.Category;
import com.gametrader.gametraderpostservice.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping("/v1/post/category")
public class CategoryController {

  private final CategoryService categoryService;

  @GetMapping("/get/all")
  public ResponseEntity<List<CategoryEntity>> getAllCategories() {
    return ResponseEntity.ok(categoryService.getAll());

  }

}
