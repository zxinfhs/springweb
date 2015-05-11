package net.zx.client;

import java.util.List;

import net.zx.bo.UserDAO;
import net.zx.pojo.User;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ClientApp {
	public static void main(String[] args) {
		System.out.println("spring mvc testing client");
		try {
			ClientApp app = new ClientApp();
			app.hibernatedInitTest();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
	}
	
	private void hibernatedInitTest() {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        
        UserDAO personDAO = context.getBean(UserDAO.class);
         
        User person = new User();
        person.setName("Pankaj"); 
         
        personDAO.save(person);
         
        System.out.println("Person::"+person);
         
        List<User> list = personDAO.list();
         
        for(User p : list){
            System.out.println("Person List::"+p);
        }
        //close resources
        context.close();    
	}
}
