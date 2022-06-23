package com.gametrader.gametraderpostservice.repository;

import com.gametrader.gametraderpostservice.entity.ImageEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<ImageEntity, Long> {
}
