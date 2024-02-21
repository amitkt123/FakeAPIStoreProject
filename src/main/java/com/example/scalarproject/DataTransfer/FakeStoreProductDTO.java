package com.example.scalarproject.DataTransfer;

//
////@Setter
//@Getter
//@NoArgsConstructor
//@AllArgsConstructor
public class FakeStoreProductDTO extends BaseDTO{
    public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	private long id;
    private String title;

    private long price;
    private String category; // here we have a category class but we choose string because it maps the ouptu
    private String Description;
    private String image;
    
    public FakeStoreProductDTO() {
    	
    }
    public FakeStoreProductDTO(long id, String title, long price, String category, String description, String image) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.category = category;
        this.Description = description;
        this.image = image;
    }


}