package net.zx.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;



@Entity
@Table(name="useraddress")
public class UserAddress {
	@Id
	@Column(name="userid")
	private int userId;
	@Column(name="address")
	private String address;
	@OneToOne
	@JoinColumn(name="userId")
	private User user;
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getAddress() {
		return address;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
	
}
