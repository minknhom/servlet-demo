package fa.training.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import fa.training.entities.Account;
import fa.training.utils.HibernateUtils;

public class AccountDaoImpl implements AccountDao {
	
	private SessionFactory sessionFactory;
	
    public AccountDaoImpl() {
		sessionFactory = HibernateUtils.getSessionFactory();
	}

	@Override
    public Account findByUsername(String username) {
        try (Session session = sessionFactory.openSession()) {
            Query<Account> query = session.createQuery("FROM Account WHERE username = :username", Account.class);
            query.setParameter("username", username);
            return query.uniqueResult();
        }
    }
	
	@Override
    public void save(Account account) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.save(account);
            session.getTransaction().commit();
        }
    }
	
	@Override
	public void update(Account account) {
		 try (Session session = sessionFactory.openSession()) {
	         session.beginTransaction();
	         session.update(account);
	         session.getTransaction().commit();
	        }
	}
	
}