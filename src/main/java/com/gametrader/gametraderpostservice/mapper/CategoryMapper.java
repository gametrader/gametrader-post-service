package com.gametrader.gametraderpostservice.mapper;

import com.gametrader.gametraderpostservice.dto.CategoryDto;
import com.gametrader.gametraderpostservice.entity.CategoryEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    CategoryEntity dtoToEntity(CategoryDto dto);

    CategoryDto entityToDto(CategoryEntity entity);
}
