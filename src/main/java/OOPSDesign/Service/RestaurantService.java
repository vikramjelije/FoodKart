package OOPSDesign.Service;

import java.util.List;

import OOPSDesign.DAO.UserDao;
import OOPSDesign.Models.Restaurant;
import OOPSDesign.Models.Review;

public class RestaurantService {

	RestaurantService rs = null;
	
	private RestaurantService() {
		
	}
	
	UserDao ud = UserDao.getInstance();
	
	public RestaurantService getInstance() {
		if (rs == null) {
			rs = new RestaurantService();
		}
		return rs;
	}
	
	public Restaurant registerRestaurant(String restaurant_name, String pincodes, String item, Long price, int quantity) throws Exception {
		 if (price <= 0 || quantity <= 0) {
			 System.out.println("Invalid value for mandatory fields");
			 
			 //TODO: throw exceptions instead of null
			 return null;
		 }
		 else if (restaurant_name.isEmpty()) {
			 System.out.println("Invalid restaurant name");
			 throw new Exception("Invalid restaurant name");
		 }
		 return ud.registerRestaurant(restaurant_name, pincodes, item, price, quantity);
	}
	 
	public Restaurant updateQuantity (String restaurant_name, Integer quantityToAdd) throws Exception {
		 if (quantityToAdd == null || quantityToAdd <= 0) {
			 System.out.println("Invalid quantity to add");
			 return null;
		 }
		 return ud.updateQuantity(restaurant_name, quantityToAdd);
	}
	 
	List<Restaurant> showRestaurant(String sortby) {
		 return ud.showRestaurant(sortby); 
	}
	 
	public Review rateRestaurant(String restaurant_name, Integer rating, String comment) throws Exception {
		 if (rating == null || rating <= 0 ||rating > 5) {
			 System.out.println("Invalid rating for retautant");
			 return null;
		 }
		 return ud.rateRestaurant(restaurant_name, rating, comment);
	}
}
