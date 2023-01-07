package sixteam.t6_10.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AccountService{
	
	@Autowired
	private AccountDao accountDao;

	public List<Account> showAllAccount() {
		return accountDao.selectAll();
	}

	public boolean removeAccount(int id) {
		return accountDao.delete(id);
	}

	public Account modify(Account account) {
		return accountDao.update(account);
	}

	public Account showAccount(int id) {
		return accountDao.select(id);
	}

	public Account add(Account account) {
		return accountDao.add(account);
	}
}