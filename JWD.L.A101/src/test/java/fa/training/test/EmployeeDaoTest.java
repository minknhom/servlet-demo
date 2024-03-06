package fa.training.test;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import fa.training.dao.AccountDao;
import fa.training.dao.AccountDaoImpl;
import fa.training.dao.EmployeeDao;
import fa.training.dao.EmployeeDaoImpl;
import fa.training.entities.Account;
import fa.training.entities.Employee;


public class EmployeeDaoTest {

private static EmployeeDao employeeDao;
private static AccountDao accountDao;
	
	@BeforeAll
    public static void setUp() {
		employeeDao = new EmployeeDaoImpl();
		accountDao = new AccountDaoImpl();  
    }
	
	@Test
    public void testSave() {
        Employee employee = new Employee();
        employee.setFirstName("minh");
        employee.setLastName("nguyen");
        employee.setAddress("dn");
        employee.setDateOfBirth(LocalDate.of(2001, 7, 25));
        employee.setDepartmentName("dpm1");
        employee.setPhone("0901611585");
        employee.setGender(1);
        employee.setRemark("rm1");
        
        Account account = new Account();
        account.setUsername("minh");
        account.setPassword("password");
        account.setEmail("minh@gmail.com");
        account.setStatus(true);
        account.setEmployee(employee);

        employeeDao.save(employee);
        accountDao.save(account);
	}
}
