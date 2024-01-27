package OOPSDesign.Models;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {
	
	public Restaurant() {
		
	}
 	
 	public Restaurant(int id, String name, String item, Long price, List<Long> serviceablePincodes, int quantity,
			List<Review> reviews, float rating, Integer createdBy) {
		this.id = id;
		this.name = name;
		this.item = item;
		this.price = price;
		this.serviceablePincodes = serviceablePincodes;
		this.quantity = quantity;
		this.reviews = reviews;
		this.rating = rating;
		this.createdBy = createdBy;
	}
 	
 	private int id;
	private String name;
 	private String item;
 	private Long price;
 	private List<Long> serviceablePincodes;
 	private int quantity;
 	private List<Review> reviews = new ArrayList<Review>();
 	
 	
 	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price2) {
		this.price = price2;
	}

	public List<Long> getServiceablePincodes() {
		return serviceablePincodes;
	}

	public void setServiceablePincodes(List<Long> serviceablePincodes) {
		this.serviceablePincodes = serviceablePincodes;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

	public float getRating() {
		return rating;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}

	public Integer getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}

	private float rating;
 	
 	private Integer createdBy; 
	
	
}
