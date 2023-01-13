package myTravels2JSF;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


@ManagedBean
@SessionScoped
public class UserController {
	
	private List<User> users;
	private UserDbUtil userDbUtil;

	public UserController() throws Exception {
		users = new ArrayList<>();

		userDbUtil = UserDbUtil.getInstance();

	}
	
	public List<User> getUsers() {
		return users;
	}

	public void loadUsers() {

		
		
		users.clear();

		try {
			
			// get all students from database
			users = userDbUtil.getUsers();
			
		} catch (Exception e) {
			
			
			// add error message for JSF page
			e.printStackTrace();
		}
	}

	public String addUser(User newUser) {
		try {
			userDbUtil.addUser(newUser);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "mytravels?faces-redirect=true";
	}
}
