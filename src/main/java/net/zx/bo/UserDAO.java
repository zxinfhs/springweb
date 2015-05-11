package net.zx.bo;

import java.util.List;

import net.zx.pojo.User;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class UserDAO {
	
	private SessionFactory sessionFactory;
	 
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void save(User p) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.persist(p);
        tx.commit();
        session.close();
    }
 
    @SuppressWarnings("unchecked")
    public List<User> list() {
        Session session = this.sessionFactory.openSession();
        List<User> personList = session.createQuery("from User").list();
        session.close();
        return personList;
    }
}
