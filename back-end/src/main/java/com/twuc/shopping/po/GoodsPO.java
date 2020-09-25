package com.twuc.shopping.po;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Table;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.validation.constraints.NotNull;
import javax.persistence.Id;


@Entity
@Table(name = "goods")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GoodsPO {
    @Id
    @GeneratedValue
    private int Id;
    @NotNull
    private String name;
    @NotNull
    private double price;
    @NotNull
    private String goodunit;
    @NotNull
    private String imgUrl;
}