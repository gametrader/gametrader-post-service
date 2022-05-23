package com.gametrader.gametraderpostservice.repository;

import com.gametrader.gametraderpostservice.entity.PostEntity;
import com.gametrader.gametraderpostservice.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<PostEntity, Long> {

    List<PostEntity> findAllByAuthorId(Long authorId);
    List<PostEntity> findAllByLocalization(String localization);
    List<PostEntity> findAllByCategory(Category category);
}
