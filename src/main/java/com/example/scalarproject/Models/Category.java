package com.example.scalarproject.Models;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Category extends BaseModel{

    private String category_name;

    public Category(){
        this.category_name = null;
    }

    public Category(String category_name) {
        this.category_name = category_name;
    }
}
