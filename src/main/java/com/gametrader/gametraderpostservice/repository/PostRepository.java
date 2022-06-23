package com.gametrader.gametraderpostservice.repository;

import com.gametrader.gametraderpostservice.dto.CategoryDto;
import com.gametrader.gametraderpostservice.entity.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<PostEntity, Long> {

    List<PostEntity> findAllByAuthorId(Long authorId);
    List<PostEntity> findAllByLocalization(String localization);
    List<PostEntity> findAllByCategory(CategoryDto category);
}
