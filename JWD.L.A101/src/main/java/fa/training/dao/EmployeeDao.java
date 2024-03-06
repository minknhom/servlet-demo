package fa.training.dao;

import java.util.List;

import fa.training.entities.Employee;

public interface EmployeeDao {

	public void save(Employee employee);
	public List<Employee> findAll();
	public List<Employee> getEmployeesByName(String name);
	public Employee getEmployeeById(int id);
	public List<Employee> getEmployeesByPage(int pageNumber, int pageSize);
	public int getTotalEmployeeCount();
	
}
