package com.gametrader.gametraderpostservice.dto;

import com.gametrader.gametraderpostservice.model.Category;

import javax.validation.constraints.NotNull;

public class PostDto {

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
}
