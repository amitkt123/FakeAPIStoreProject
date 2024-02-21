package com.example.scalarproject.Models;

public class Product extends BaseModel {
    public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public Long getQuantity() {
		return quantity;
	}
	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}
	public Long getPrice() {
		return price;
	}
	public void setPrice(Long price) {
		this.price = price;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
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
