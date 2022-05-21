package com.gametrader.gametraderpostservice.controller;

import com.gametrader.gametraderpostservice.model.Category;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController("/v1/category")
public class CategoryController {

    @GetMapping("/all")
    public ResponseEntity<List<Category>> getAllCategories() {
        return new ResponseEntity<>(Arrays.stream(Category.values()).collect(Collectors.toList()), HttpStatus.OK);
    }
}
