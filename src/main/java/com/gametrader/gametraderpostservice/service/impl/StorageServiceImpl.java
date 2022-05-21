package com.gametrader.gametraderpostservice.service.impl;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.PutObjectResult;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;
import com.amazonaws.util.IOUtils;
import com.gametrader.gametraderpostservice.service.StorageService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Objects;

@Service
@AllArgsConstructor
@Slf4j
public class StorageServiceImpl implements StorageService {
    private final String bucketName = System.getenv("AWS_BUCKET_NAME");
    private AmazonS3 s3Client;

    @Override
    public String uploadFile(MultipartFile file) {
        String fileName = System.currentTimeMillis()+"_"+file.getOriginalFilename();
        File fileObject = convertMultiPartFileToFile(file);
        PutObjectResult putObjectResult = s3Client.putObject(new PutObjectRequest(bucketName, fileName, fileObject));
        fileObject.delete();
        return fileName;
    }

    @Override
    public byte[] downloadFile(String fileName) {
        S3Object object = s3Client.getObject(bucketName, fileName);
        S3ObjectInputStream inputStream = object.getObjectContent();
        try {
            return IOUtils.toByteArray(inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String deleteFile(String fileName) {
        s3Client.deleteObject(bucketName, fileName);
        return fileName + "successfully removed!";
    }

    private File convertMultiPartFileToFile(MultipartFile file) {
        File convertedFile = new File(Objects.requireNonNull(file.getOriginalFilename()));
        try (FileOutputStream fos = new FileOutputStream(convertedFile)) {
            fos.write(file.getBytes());
        } catch (IOException e) {
            log.error("Error converting multipart file to file", e);
        }
        return convertedFile;
    }
}
