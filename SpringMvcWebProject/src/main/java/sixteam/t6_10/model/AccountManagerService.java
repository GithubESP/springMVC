package sixteam.t6_10.model;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
@Transactional
public class AccountManagerService {
	
	@Autowired
	private AccountManagerDao aDao;
	
	public boolean checkLogin(AccountManager accountManager) {
		return aDao.checkLogin(accountManager);
	}
}
