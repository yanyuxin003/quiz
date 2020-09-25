package com.twuc.shopping.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Goods {
    @NotNull
    private String name;
    @NotNull
    private double price;
    @NotNull
    private String goodunit;
    @NotNull
    private String imgUrl;
}

