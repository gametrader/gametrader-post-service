package com.gametrader.gametraderpostservice.mapper;

import com.gametrader.gametraderpostservice.dto.CategoryDto;
import com.gametrader.gametraderpostservice.dto.PostDto;
import com.gametrader.gametraderpostservice.entity.CategoryEntity;
import com.gametrader.gametraderpostservice.entity.PostEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PostMapper {

    @Mapping(source = "promoted", target = "isPromoted")
    PostEntity dtoToEntity(PostDto dto);

    @Mapping(source = "promoted", target = "isPromoted")
    PostDto entityToDto(PostEntity entity);

    CategoryDto map(CategoryEntity entity);

    CategoryEntity map(CategoryDto entity);
}
