package com.example.scalarproject.DataTransfer;

//output
/*{
    id:1,
    title:'...',
    price:'...',
    category:'...',
    description:'...',
    image:'...'
   }*/

import com.example.scalarproject.Models.Category;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ProductDTO extends BaseDTO{
    private long id;
    private String title;

    private long price;
    private String category; // here we have a category class but we choose string because it maps the ouptu
    private String Description;
    private String image;

    public ProductDTO(long id, String title, long price, String category, String description, String image) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.category = category;
        this.Description = description;
        this.image = image;
    }


}