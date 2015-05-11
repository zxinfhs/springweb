package net.zx.bo;
import java.util.List;

import net.zx.pojo.User;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserManager {
	
	private UserDAO userDAO;
	public void setUserDAO(UserDAO dao) {
		this.userDAO = dao;
	}
	
	@Transactional
	public void addUser(User user) {
		this.userDAO.save(user);
	}
	@Transactional
	public List<User> listUsers() {
		return this.userDAO.list();
	}

}
