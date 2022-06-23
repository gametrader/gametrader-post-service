package com.gametrader.gametraderpostservice.controller;

import com.gametrader.gametraderpostservice.entity.ImageEntity;
import com.gametrader.gametraderpostservice.service.StorageService;
import lombok.AllArgsConstructor;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
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

    @GetMapping("/get")
    public ResponseEntity<Set<ByteArrayResource>> getImages(@RequestBody Set<ImageEntity> imagesNames) {
        Set<ByteArrayResource> images = new HashSet<>();
        for (ImageEntity imagesName : imagesNames) {
            images.add(new ByteArrayResource(storageService.downloadFile(imagesName.getFileName())));
        }
        return ResponseEntity
                .ok()
                .header("Content-Type", "application/octet-stream")
                .body(images);
    }
}
