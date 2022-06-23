package com.gametrader.gametraderpostservice.repository;

import com.gametrader.gametraderpostservice.entity.CategoryEntity;
import com.gametrader.gametraderpostservice.entity.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<PostEntity, Long> {

    List<PostEntity> findAllByAuthorId(Long authorId);
    List<PostEntity> findAllByLocalization(String localization);
    List<PostEntity> findAllByCategory(CategoryEntity category);

    List<PostEntity> findAllByCategoryAndLocalization(CategoryEntity category, String localization);
}
