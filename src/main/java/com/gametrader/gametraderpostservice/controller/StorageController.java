package com.gametrader.gametraderpostservice.controller;

import com.gametrader.gametraderpostservice.entity.Image;
import com.gametrader.gametraderpostservice.service.StorageService;
import lombok.AllArgsConstructor;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@Controller
@RequestMapping("/v1/post/storage")
public class StorageController {

    private final StorageService storageService;

    @RequestMapping("/get")
    public ResponseEntity<Set<ByteArrayResource>> getImages(@RequestBody Set<Image> imagesNames) {
        Set<ByteArrayResource> images = new HashSet<>();
        for (Image imagesName : imagesNames) {
            images.add(new ByteArrayResource(storageService.downloadFile(imagesName.getFileName())));
        }
        return ResponseEntity
                .ok()
                .header("Content-type", "application/octet-stream")
                .body(images);
    }
}
