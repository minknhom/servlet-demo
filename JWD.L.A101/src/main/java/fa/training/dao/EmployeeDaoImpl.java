package fa.training.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import fa.training.entities.Employee;
import fa.training.utils.HibernateUtils;

public class EmployeeDaoImpl implements EmployeeDao {

	private SessionFactory sessionFactory;

	public EmployeeDaoImpl() {
		sessionFactory = HibernateUtils.getSessionFactory();
	}

	@Override
	public void save(Employee employee) {
		try (Session session = sessionFactory.openSession()) {
			session.beginTransaction();
			session.save(employee);
			session.getTransaction().commit();
		}
	}

	@Override
	public List<Employee> findAll() {
		try (Session session = sessionFactory.openSession()) {
			String hql = "FROM Employee";
			return session.createQuery(hql, Employee.class).list();
		}
	}

	@Override
	public Employee getEmployeeById(int id) {
		try (Session session = HibernateUtils.getSessionFactory().openSession()) {
			return session.get(Employee.class, id);
		}
	}

	@Override
	public List<Employee> getEmployeesByName(String name) {
		List<Employee> employees = new ArrayList<>();

		try (Session session = sessionFactory.openSession()) {
			String hql = "FROM Employee WHERE CONCAT(firstName, ' ', lastName) = :emp_name";
			Query<Employee> query = session.createQuery(hql, Employee.class);
			query.setParameter("emp_name", name);
			employees = query.getResultList();
		}
		return employees;
	}

	@Override
    public List<Employee> getEmployeesByPage(int pageNumber, int pageSize) {
        Session session = null;
        List<Employee> employees = new ArrayList<>();

        try {
            session = sessionFactory.openSession();
            String hql = "FROM Employee ORDER BY employeeId";
            Query<Employee> query = session.createQuery(hql, Employee.class);
            query.setFirstResult((pageNumber - 1) * pageSize);
            query.setMaxResults(pageSize);

            employees = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }

        return employees;
    }

    @Override
    public int getTotalEmployeeCount() {
        Session session = null;
        int totalEmployees = 0;

        try {
            session = sessionFactory.openSession();
            String hql = "SELECT COUNT(*) FROM Employee";
            Query<Long> query = session.createQuery(hql, Long.class);

            totalEmployees = Math.toIntExact(query.uniqueResult());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }

        return totalEmployees;
    }
}
