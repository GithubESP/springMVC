package sixteam.t6_10.model;

import java.sql.Blob;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sixteam.t6_10.model.Account;

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
	
	public Account add(Integer id, String account, String password, Blob image) {
		return accountDao.add(new Account(id, account, password, image));
	}
}
