package net.zx.client;

import java.util.List;

import net.zx.bo.UserDAO;
import net.zx.pojo.User;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ClientApp {
	private ClassPathXmlApplicationContext _context;
	private SessionFactory _sessionFactory;
	
	
	public static void main(String[] args) {
		System.out.println("spring mvc testing client");
		try {
			ClientApp app = new ClientApp();
			app.hibernat4InitTest();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
	}
	private void hibernat4InitTest() {
		_context = new ClassPathXmlApplicationContext("spring4.xml");
        
        UserDAO personDAO = _context.getBean(UserDAO.class);
         
        User person = new User();
        person.setName("Pankaj"); 
         
        personDAO.save(person);
         
        System.out.println("Person::"+person);
         
        List<User> list = personDAO.list();
         
        for(User p : list){
            System.out.println("Person List::"+p);
        }
        //close resources
        _context.close();  
	}
	
	private void hibernat3InitTest() {

		
		_context = new ClassPathXmlApplicationContext("spring.xml");
        
        UserDAO personDAO = _context.getBean(UserDAO.class);
         
        User person = new User();
        person.setName("Pankaj"); 
         
        personDAO.save(person);
         
        System.out.println("Person::"+person);
         
        List<User> list = personDAO.list();
         
        for(User p : list){
            System.out.println("Person List::"+p);
        }
        //close resources
        _context.close();    
	}

	private void dd() {
		_sessionFactory = (SessionFactory)_context.getBean(SessionFactory.class);
		Session session = _sessionFactory.openSession();
		List<User> list = session.createQuery("from User where Id > 3").list();
		for (User u : list) {
			System.out.println(u.getName());
		}
		session.close();
	}
}
