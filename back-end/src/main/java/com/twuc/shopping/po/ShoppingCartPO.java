package com.twuc.shopping.po;

import javax.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "shoppingCart")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ShoppingCartPO {
    @Id
    @GeneratedValue
    private int id;
    @NotNull
    private String name;
    @NotNull
    private String goodunit;
    @NotNull
    private double price;
    @NotNull
    private int count;
    @NotNull
    private String imgUrl;
}
