package net.zx.bo;

import java.util.ArrayList;
import java.util.List;

import net.zx.exception.BusinessException;
import net.zx.pojo.User;

public class UserManager {
	
	public boolean validateUser(String userName, String password) {
		return true;
	}
	
	public User addUser() {
		return makeFakeUser(10);
	}
	
	public User deleteUser() throws BusinessException {
		int i = 4;
		if (i > 1) {
			throw new BusinessException();
		}
		return null;
	}
	
	public User deleteUser(int id) {
		return makeFakeUser(id);
	}
	
	public User getUser(int id) {
		return makeFakeUser(id);
	}
	
	public List<User> listUser() {
		List<User> users = new ArrayList<User>();
		users.add(makeFakeUser(1));
		users.add(makeFakeUser(2));
		users.add(makeFakeUser(3));
		return users;
		
	} 
	
	private User makeFakeUser(int id) {
		User fakeUser = new User();
		fakeUser.setId(id);
		fakeUser.setUserName("admin" + id);
		fakeUser.setPassword("adminpass");
		return fakeUser;
	}
	
	 

}
