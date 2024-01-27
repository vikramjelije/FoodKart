package OOPSDesign.Service;

import java.util.List;

import OOPSDesign.DAO.UserDao;
import OOPSDesign.Models.Order;

public class OrderService {

	private OrderService() {
		
	}
	
	private OrderService os = null;
	
	public OrderService getInstance() {
		if (os == null) {
			os = new OrderService();
		}
		return os;
	}
	
	UserDao ud = UserDao.getInstance();
	
	public Order placeOrder (String name, Integer quantity) throws Exception {
		if (quantity <= 0) {
			System.out.println("Invalid quantity");  
			throw new Exception("Invalid quantity");
		}
		return ud.placeOrder(name, quantity);
	}
	
	public List<Order> listOrders() throws Exception {
		return ud.listOrders();
	}
}
