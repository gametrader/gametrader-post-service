package com.gametrader.gametraderpostservice.dto;

import com.gametrader.gametraderpostservice.entity.ImageEntity;
import com.gametrader.gametraderpostservice.model.Category;
import lombok.*;

import javax.validation.constraints.NotNull;
import java.util.Set;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PostDto {

    private Long id;
    @NotNull
    private Long authorId;
    @NotNull
    private String title;
    @NotNull
    private Category category;
    private String description;
    @NotNull
    private String localization;
    private String emailAddress;
    private String phoneNumber;
    @NotNull
    private Long price;
    private Set<ImageEntity> image;
    @NotNull
    private boolean isPromoted;
}
