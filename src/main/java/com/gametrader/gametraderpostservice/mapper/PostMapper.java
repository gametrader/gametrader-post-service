package com.gametrader.gametraderpostservice.mapper;

import com.gametrader.gametraderpostservice.dto.PostDto;
import com.gametrader.gametraderpostservice.entity.PostEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PostMapper {

    PostEntity dtoToEntity(PostDto dto);

    PostDto entityToDto(PostEntity entity);
}
