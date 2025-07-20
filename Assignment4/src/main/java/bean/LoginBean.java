package bean;

import daos.UserDao;
import daos.UserDaoImpl;
import pojos.User;
//import sun.util.resources.ext.CalendarData_th;

public class LoginBean {
	private String email;
	private String password;
	private User user;
	
	public LoginBean() {
		
	}

	public LoginBean(String email, String password, User user) {
		super();
		this.email = email;
		this.password = password;
		this.user = user;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public void login() {
		try(UserDao uDao=new UserDaoImpl()){
			
		User user2=uDao.findByEmail(email);
		System.out.println(user2);
			if(user2.getPasswd().equals(password)) {
				user=user2;
			}
			
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	

}
