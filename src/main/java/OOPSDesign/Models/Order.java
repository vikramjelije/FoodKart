package OOPSDesign.Models;

public class Order {
	private int orderID;
	private int restaurantID;
	private int userID;
	private int quantity;
	private Long cost;
	private String item;
	
	public Order(int orderID, int restaurantID, int userID, int quantity, Long cost, String item) {
		super();
		this.orderID = orderID;
		this.restaurantID = restaurantID;
		this.userID = userID;
		this.quantity = quantity;
		this.cost = cost;
		this.item = item;
	}
	
	public Order() {
		
	}

	public int getOrderID() {
		return orderID;
	}
	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}
	public int getResID() {
		return restaurantID;
	}
	public void setResID(int restaurantID) {
		this.restaurantID = restaurantID; 
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Long getPrice() {
		return cost;
	}
	public void setPrice(Long cost) {
		this.cost = cost;
	}
	public String getItem () {
		return item;
	}
	public void setItem(String cost) {
		this.item = item;
	}
	
}
