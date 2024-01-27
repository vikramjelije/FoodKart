package OOPSDesign.Service;

import Constants.Gender;
import OOPSDesign.DAO.UserDao;
import OOPSDesign.Models.User;

public class UserService {

	private static UserService instance;
	
	public static UserService getInstance() {
		if (instance  == null) {
			instance  = new UserService();
		}
		return instance;
	}
	
	private UserService() {
		
	}
	
	UserDao ud = UserDao.getInstance();
	
	
	public User register_User(String name, Gender gender, Long phone, Long pincode) {
		if (name.isEmpty()) {
			System.out.println("Invalid name");
			return null;
		}
		else if (phone == null || phone <= 0) {
			System.out.println("Invalid phone number");
			return null;
		}
		else if (pincode == null || pincode < 0) {
			System.out.println("Invalid pincode");
			return null;
		}
		return ud.registerUser(phone, name, pincode, gender);
	}
	
	public User login(Long id) throws Exception {
		return ud.login(id);
	}
}
