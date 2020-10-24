package com.twuc.shopping.po;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import javax.validation.constraints.NotNull;


@Entity
@Table(name = "goods")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GoodsPO {
    @Id
    @GeneratedValue
    private int id;
    @NotNull
    private String name;
    @NotNull
    private double price;
    @NotNull
    private String goodunit;
    @NotNull
    private String imgUrl;
}