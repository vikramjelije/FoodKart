package OOPSDesign.DAO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

import Comparators.SortByPrice;
import Comparators.SortByRating;
import Constants.Gender;
import OOPSDesign.Models.Order;
import OOPSDesign.Models.Restaurant;
import OOPSDesign.Models.Review;
import OOPSDesign.Models.User;
import Utils.IDGenerator;

public class UserDao {

	private static UserDao instance = null;
	
	public static UserDao getInstance() {
		if (instance  == null) {
			instance = new UserDao(); 
		}
		return instance;
	}
	
	private HashMap<Integer, User> userHashMap = new HashMap();
	private HashMap<Long, Integer> phoneNumberMap = new HashMap();
	private HashMap<String, Restaurant> restaurantMap = new HashMap();
	
	private User loggedInUser = null;

	public User registerUser(Long phone, String name, Long pincode, Gender gender) {
		User user;
		if (phoneNumberMap.containsKey(phone)) {
			user = userHashMap.get(phoneNumberMap.get(phone));
			System.out.println("User already exists with phone number " + phone + " with user details" + user);
		}
		else {
			user = new User(IDGenerator.getID(), name, gender, phone, pincode);
			phoneNumberMap.put(pincode, user.getId());
			userHashMap.put(user.getId(), user);
			System.out.println("Succesfully created new user with details " + user);
		}
		return user;
	}

	public Review rateRestaurant(String restaurant_name, Integer rating, String comment) throws Exception {
		Restaurant rs = restaurantMap.get(restaurant_name);
		if (rs == null) {
			System.out.println("No restaurant found with name " + restaurant_name);
			throw new Exception("No restaurant found with given name");
		}
		
		Review rw = new Review();
		
		rw.setComment(comment);
		rw.setId(IDGenerator.getID());
		rw.setScore(rating);
		
		//first review
		if (rs.getReviews() == null || rs.getReviews().isEmpty()) {
			rs.setRating(Float.valueOf(rating));
		}
		else {
			float currentScore = (rs.getRating() * rs.getReviews().size() + rating) / (rs.getReviews().size() + 1);
			rs.setRating(currentScore);
		}
		
		rs.getReviews().add(rw);
		return rw;
	}

	public Restaurant registerRestaurant(String restaurant_name, String pincodes, String item, Long price,
			int quantity) throws Exception {
		if (loggedInUser == null) {
			System.out.println("User not logged in.");
			throw new Exception("No logged user found");
		}
		
		if (restaurantMap.containsKey(restaurant_name)) {
			System.out.println("Restaurant with name " + restaurant_name + " is already registered.");
			throw new Exception("Restaurant name already used");
		}
		
		List<String> pinCodeList = Arrays.asList(pincodes.split(","));
		List<Long> pins = new ArrayList<>();
		if (!pincodes.isEmpty()) {
			for (String s: pinCodeList) {
				if (!s.chars().allMatch(Character::isDigit)) {
					System.out.println("Invalid pincodes provided");
					throw new Exception("Invalid pincodes provided");
				}
				pins.add(Long.parseLong(s));
			}
		}
		Restaurant rs = new Restaurant();
		
		//TODO: check feasibility 
		rs.setId(IDGenerator.getID());
		rs.setName(restaurant_name);
		rs.setServiceablePincodes(pins);
		rs.setItem(item);
		rs.setPrice(price);
		rs.setQuantity(quantity);
		
		
		rs.setCreatedBy(loggedInUser.getId());
		
		restaurantMap.put(rs.getName(), rs);
		
		loggedInUser.getRestaurants().add(rs);
		
		System.out.println("Restaurant sucessfully registered with id " + rs.getId() + " ");
		return rs;
	}

	public Restaurant updateQuantity(String restaurant_name, Integer quantityToAdd) throws Exception {
		Restaurant rs = restaurantMap.get(restaurant_name);
		if (rs == null) {
			System.out.println("No restaurant found with name " + restaurant_name);
			throw new Exception("No restaurant found with given name");
		}
		
		rs.setQuantity(rs.getQuantity() + quantityToAdd);
		
		return rs;
	}

	public List<Restaurant> showRestaurant(String sortby) {
		List<Restaurant> allRestaurants = loggedInUser.getRestaurants();
		List<Restaurant> serviceableRestaurants = new ArrayList<>();
		
		for (Restaurant restaurant : allRestaurants) {
			if (restaurant.getServiceablePincodes().contains(loggedInUser.getPincode()) &&  restaurant.getQuantity() > 0) {
				serviceableRestaurants.add(restaurant);
			}
		}
		
		if (sortby.equalsIgnoreCase("rating")) {
			Collections.sort(serviceableRestaurants, new SortByRating());
			for (Restaurant restaurant : serviceableRestaurants) {
				System.out.println("restaurant id: " + restaurant.getId() + " name: " + restaurant.getName() + " item: " + restaurant.getItem() +
						" price: " + restaurant.getPrice() + " rating: " + restaurant.getRating());
			}
			return serviceableRestaurants;
		}
		
		Collections.sort(serviceableRestaurants, new SortByPrice());
		for (Restaurant restaurant : serviceableRestaurants) {
			System.out.println("restaurant id: " + restaurant.getId() + " name: " + restaurant.getName() + " item: " + restaurant.getItem() +
					" price: " + restaurant.getPrice() + " rating: " + restaurant.getRating());
		}
		return serviceableRestaurants;
	}

	public User login(Long phone) throws Exception {
		
		if (!phoneNumberMap.containsKey(phone)) {
			System.out.println("No user found with phone number " + phone);
			throw new Exception("User isn't registered");
		}
		
		User user = userHashMap.get(phoneNumberMap.get(phone));
		loggedInUser = user;
		return user; 
	}

	public Order placeOrder(String restaurantName, Integer quantity) throws Exception {
		Restaurant restaurant = restaurantMap.get(restaurantName);
		if (restaurant == null) {
			throw new Exception("Invalid restaurant name");
		}
		else if (restaurant.getQuantity() == 0) {
			throw new Exception("restaurant is out of stock. Please try again later");
		}
		else if (restaurant.getQuantity() < quantity) {
			throw new Exception("invalid quantity");
		}
		
		Order order = new Order();
		order.setOrderID(IDGenerator.getID());
		order.setItem(restaurant.getItem());
		order.setPrice((Long)(quantity * restaurant.getPrice()));
		order.setQuantity(quantity);
		order.setResID(restaurant.getId());
		order.setUserID(loggedInUser.getId());
		
		restaurant.setQuantity(restaurant.getQuantity() - quantity);
		loggedInUser.getOrders().add(order);
		
		return order;
	}

	public List<Order> listOrders() throws Exception {
		if (loggedInUser == null) {
			throw new Exception("User not loggedin");
		}
		return loggedInUser.getOrders();
	}
}
