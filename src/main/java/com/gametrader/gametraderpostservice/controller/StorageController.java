package com.gametrader.gametraderpostservice.controller;

import com.gametrader.gametraderpostservice.entity.ImageEntity;
import com.gametrader.gametraderpostservice.service.StorageService;
import lombok.AllArgsConstructor;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@RestController
@RequestMapping("/v1/post/storage")
public class StorageController {

    private final StorageService storageService;


    @PostMapping(value = "/add", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Set<ImageEntity>> addImages(@RequestParam MultipartFile[] files) {
        Set<MultipartFile> filesSet = new HashSet<>();
        filesSet.addAll(Arrays.asList(files));
        return new ResponseEntity<>(storageService.addImages(filesSet), HttpStatus.CREATED);
    }

    @GetMapping("/get/{imageName}")
    public ResponseEntity<ByteArrayResource> getImages(@PathVariable String imageName) {
        ByteArrayResource image = new ByteArrayResource(storageService.downloadFile(imageName));
        return ResponseEntity
                .ok()
                .header("Content-Type", "application/octet-stream")
                .body(image);
    }
}
