package fa.training.test;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import fa.training.dao.AccountDao;
import fa.training.dao.AccountDaoImpl;
import fa.training.entities.Account;

public class AccountDaoTest {

	private static AccountDao accountDao;
	
	@BeforeAll
    public static void setUp() {
		accountDao = new AccountDaoImpl();  
    }
 
	@Test
    public void testSave() {
        Account account = new Account();
        account.setUsername("admin");
        account.setEmail("admin@gmail.com");
        account.setPassword("password");
        account.setStatus(true);

        accountDao.save(account);
	}
	
	@Test
	public void testFindByUsername() {
		Account account= accountDao.findByUsername("admin");
		System.out.println(account);	
	}

	@Test
	public void testUpdatePassword() {
		Account account = accountDao.findByUsername("admin");
		account.setPassword("newpassowrd");
		
		accountDao.update(account);
	}
}
