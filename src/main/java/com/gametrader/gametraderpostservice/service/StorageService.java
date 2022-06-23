package com.gametrader.gametraderpostservice.service;

import com.gametrader.gametraderpostservice.entity.ImageEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.Set;

public interface StorageService {

    String uploadFile(MultipartFile file);
    byte[] downloadFile(String fileName);
    String deleteFile(String fileName);
    Set<ImageEntity> addImages(Set<MultipartFile> files);
}
