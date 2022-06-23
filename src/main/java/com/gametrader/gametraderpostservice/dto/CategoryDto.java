package com.gametrader.gametraderpostservice.dto;

import lombok.*;

import javax.validation.constraints.NotNull;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CategoryDto {

    private Long id;
    @NotNull
    private String name;
    @NotNull
    private String iconName;
}
