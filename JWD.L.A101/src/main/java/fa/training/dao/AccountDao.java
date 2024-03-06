package fa.training.dao;

import fa.training.entities.Account;

public interface AccountDao {

	 public Account findByUsername(String username);
	 public void save(Account account);
	 public void update(Account account);
}
