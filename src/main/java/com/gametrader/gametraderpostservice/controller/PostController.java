package com.gametrader.gametraderpostservice.controller;

import com.gametrader.gametraderpostservice.dto.PostDto;
import com.gametrader.gametraderpostservice.service.PostService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;


@RestController
@RequestMapping("/v1/post")
@AllArgsConstructor
public class PostController {

    private final PostService postService;

    @PostMapping("/create")
    public ResponseEntity<Void> createPost(@RequestBody @NotNull PostDto dto) {

        postService.createPost(dto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Void> updatePost(@RequestBody @NotNull PostDto dto) {
        postService.updatePost(dto);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<PostDto> getPostById(@PathVariable @NotNull Long id) {
        return new ResponseEntity<>(postService.getPostById(id), HttpStatus.OK);
    }

    @GetMapping("/get/all")
    public ResponseEntity<List<PostDto>> getAllPosts() {
        return new ResponseEntity<>(postService.getAllPosts(), HttpStatus.OK);
    }

    @GetMapping("/get/all/{authorId}")
    public ResponseEntity<List<PostDto>> getAllPostsByAuthorId(@PathVariable @NotNull Long authorId) {
        return new ResponseEntity<>(postService.getPostsByAuthorId(authorId), HttpStatus.OK);
    }

    @GetMapping("/get/all/localization{localization}")
    public ResponseEntity<List<PostDto>> getAllPostsByLocalization(@PathVariable @NotNull String localization) {
        return new ResponseEntity<>(postService.getPostsByLocalization(localization), HttpStatus.OK);
    }

    @GetMapping("/get/all/category/{categoryId}")
    public ResponseEntity<List<PostDto>> getAllPostsByCategory(@PathVariable @NotNull Long categoryId) {
        return new ResponseEntity<>(postService.getPostsByCategory(categoryId), HttpStatus.OK);
    }

    @GetMapping("/get/all/category-and-localization/{categoryId}/{localization}")
    public ResponseEntity<List<PostDto>> getAllPostsByCategory(@PathVariable @NotNull Long categoryId, @PathVariable @NotNull String localization) {
        return new ResponseEntity<>(postService.getPostsByCategoryAndLocalization(categoryId, localization), HttpStatus.OK);
    }
}
