package com.gametrader.gametraderpostservice.controller;

import com.gametrader.gametraderpostservice.dto.PostDto;
import com.gametrader.gametraderpostservice.model.Category;
import com.gametrader.gametraderpostservice.service.PostService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Set;


@RestController
@RequestMapping("/v1/post")
@AllArgsConstructor
public class PostController {

    private final PostService postService;

    @PostMapping("/create")
    public ResponseEntity<Void> createPost(@RequestBody @NotNull PostDto dto, @RequestParam Set<MultipartFile> files) {

        postService.createPost(dto, files);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Void> updatePost(@RequestBody @NotNull PostDto dto, @PathVariable @NotNull Long id, @RequestParam Set<MultipartFile> files) {
        postService.updatePost(dto, id, files);
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

    @GetMapping("/get/all/{localization}")
    public ResponseEntity<List<PostDto>> getAllPostsByLocalization(@PathVariable @NotNull String localization) {
        return new ResponseEntity<>(postService.getPostsByLocalization(localization), HttpStatus.OK);
    }

    @GetMapping("/get/all/{category}")
    public ResponseEntity<List<PostDto>> getAllPostsByCategory(@PathVariable @NotNull Category category) {
        return new ResponseEntity<>(postService.getPostsByCategory(category), HttpStatus.OK);
    }
}
