package com.example.scalarproject.Models;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class Product extends BaseModel {
    private String title;
    private String details;
    private Long quantity;
    private Long price;
    private Category category;

    public Product(){
        this.title = null;
        this.details = null;
        this.quantity = 0L;
        this.price = 0L;
        this.category = null;
    }
    public Product(String title, String details, Long quantity, Long price, Category cat ) {
        this.title = title;
        this.details = details;
        this.quantity = quantity;
        this.price = price;
        this.category = cat;
    }


}
