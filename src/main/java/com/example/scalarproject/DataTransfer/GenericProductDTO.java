package com.example.scalarproject.DataTransfer;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class GenericProductDTO extends BaseDTO{
    private long id;
    private String title;
    private long price;
    private String category; // here we have a category class but we choose string because it maps the ouptu
    private String Description;
    private String image;

    public GenericProductDTO() {

    }

    public GenericProductDTO(long id, String title, long price, String category, String description, String image) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.category = category;
        Description = description;
        this.image = image;
    }

}
