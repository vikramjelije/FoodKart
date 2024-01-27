package OOPSDesign.Models;

import java.util.ArrayList;
import java.util.List;

import Constants.Gender;

public class User {

	private int id;
	private String name;
	private Gender gender; 
	private Long phoneNumber;
	private Long pincode;
	private List<Restaurant> restaurants = new ArrayList<Restaurant>();
	private List<Order> orders = new ArrayList<Order>();
	
	public User(int id, String name, Gender gender, Long phoneNumber, Long pincode) {
		
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.phoneNumber = phoneNumber;
		this.pincode = pincode;
		 
	}

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

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Long getPincode() {
		return pincode;
	}

	public void setPincode(Long pincode) {
		this.pincode = pincode;
	}

	public List<Restaurant> getRestaurants() {
		return restaurants;
	}

	public void setRestaurants(List<Restaurant> restaurants) {
		this.restaurants = restaurants;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
	

}
