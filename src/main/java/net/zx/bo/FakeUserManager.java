package net.zx.bo;

import java.util.ArrayList;
import java.util.List;

import net.zx.exception.BusinessException;
import net.zx.pojo.FakeUser;
import net.zx.pojo.User;

public class FakeUserManager {
	public boolean validateUser(String userName, String password) {
		return true;
	}
	
	public FakeUser addUser() {
		return makeFakeUser(10);
	}
	
	public User deleteUser() throws BusinessException {
		int i = 4;
		if (i > 1) {
			throw new BusinessException();
		}
		return null;
	}
	
	public FakeUser deleteUser(int id) {
		return makeFakeUser(id);
	}
	
	public FakeUser getUser(int id) {
		return makeFakeUser(id);
	}
	
	public List<FakeUser> listUser() {
		List<FakeUser> users = new ArrayList<FakeUser>();
		users.add(makeFakeUser(1));
		users.add(makeFakeUser(2));
		users.add(makeFakeUser(3));
		return users;
		
	} 
	
	private FakeUser makeFakeUser(int id) {
		FakeUser fakeUser = new FakeUser();
		fakeUser.setId(id);
		fakeUser.setUserName("admin" + id);
		fakeUser.setPassword("adminpass");
		return fakeUser;
	}

}

