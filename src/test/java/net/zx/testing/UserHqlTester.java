package net.zx.testing;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;

import net.zx.pojo.Role;
import net.zx.pojo.User;
import net.zx.pojo.UserAddress;
import net.zx.pojo.UserEmail;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserHqlTester {
	private static SessionFactory _factory;
	private static ClassPathXmlApplicationContext _context;
	private static Session _session;
	@BeforeClass
	public static void init() {
		_context = new ClassPathXmlApplicationContext("spring4.xml");
		_factory = _context.getBean(SessionFactory.class);
	}
	@AfterClass
	public static void exit() {
		
	}
	@Before
	public void setup() {
		_session = _factory.openSession();
	}
	@After
	public void tearDown() {
		_session.close();
	}
	@Test
	@SuppressWarnings(value = { "unchecked" })
	public void queryT1() {
		List<User> list = _session.createQuery("from User where Id < 3").list();
		Assert.assertEquals(2, list.size());
	}
	@Test
	@SuppressWarnings(value = {"unchecked"})
	public void queryT2() {
		List<User> list1 = _session.createQuery("from User").list();
		List<User> list2 = _session.createQuery("from User ORDER BY Id ").list();
		List<Object[]> list3 = _session.createQuery("select sum(U.id), U.name from User U GROUP BY U.name").list();
		for(Object[] o : list3) {
			System.out.println("" + o[0] + "  --  " + o[1]);
		}
	}
	@Test
	public void addTest() {
		Transaction tx  = _session.getTransaction();
		tx.begin();
		User u = new User();
		u.setName("newName");
		u.setUpdated(new Timestamp(Calendar.getInstance().getTime().getTime()));
		_session.persist(u);
		tx.commit();
	}
	@Test
	public void getUserAddressTester() {
		User user = (User)_session.get(User.class, 4);
		UserAddress address = user.getUserAddress();
		Assert.assertEquals("belmore", address.getAddress());
	}
	
	@Test
	public void getUserFromAddressTester() {
		UserAddress address = (UserAddress)_session.get(UserAddress.class, 1);
		User user = address.getUser();
		Assert.assertEquals("Michael", user.getName());
	}
	
	@Test
	public void getUserEmailTester() {
		User user = (User)_session.get(User.class, 1);
		List<UserEmail> emails = user.getEmails();
		Assert.assertEquals(3, emails.size());
	}
	
	@Test
	public void getRoleUserTester() {
		Role role = (Role)_session.get(Role.class, 3);
		Assert.assertEquals(4, role.getUsers().size());
		
		User user = (User)_session.get(User.class, 2);
		Assert.assertEquals(2,  user.getRoles().size());
	}
}
