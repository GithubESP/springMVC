package sixteam.t6_10.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class AccountManagerDao {
	@Autowired
	private SessionFactory factory;
	
	public boolean checkLogin(AccountManager accountManager) {
		Session session = factory.openSession();
		
		String hqlstr = "from AccountManager where username=:user and password=:pwd";
		Query<AccountManager> query = session.createQuery(hqlstr, AccountManager.class);
		query.setParameter("user", accountManager.getUsername());
		query.setParameter("pwd", accountManager.getPassword());
		
		AccountManager resultBean = query.uniqueResult();
		session.close();
		
		if(resultBean!=null) {
			return true;
		}
		return false;
	}

}
