package sixteam.t6_10.model;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;


import t6_10.bean.Account;
import t6_10.dao.AccountDao;
import tw.hibernatedemo.util.HibernateUtil;

public class AccountDaoImpl implements AccountManagerDao{
	
	private SessionFactory factory = HibernateUtil.getSessionFactory();
	
//	private Session session = factory.getCurrentSession();
	
	// 依賴注入，Dependency Injection
	//	public AccountDaoImpl(Session session) {
	//		this.session = session;
	//	}
	
//	public Session getSession() {
//		return session;
//	}
//	
	public AccountDaoImpl() {
	
	}

	@Override
	public List<Account2> selectAll(){
		Session session = factory.getCurrentSession();
    	Query<Account2> query = session.createQuery("from Account ORDER BY id ASC", Account2.class);
    	List<Account2> result = query.getResultList();
    	System.out.println(result);
    	return result;
	}	
	
	@Override
	public boolean delete(Integer id) {
		Session session = factory.getCurrentSession();
		Account2 account = session.get(Account2.class, id);
		
		if(account != null) {
			session.delete(account);
			return true;
		}
		return false;
	}
	
	@Override
	public Account2 update(Account2 account) {
		Session session = factory.getCurrentSession();
		Account2 accountBean = session.get(Account2.class, account.getId());
		if(accountBean != null) {
			accountBean.setAccount(account.getAccount());
			accountBean.setPassword(account.getPassword());
			accountBean.setImage(account.getImage());
		}
		return accountBean;
	}
	
	@Override
	public Account2 select(Integer id) {
		Session session = factory.getCurrentSession();
		return session.get(Account2.class, id);
	}

	@Override
	public Account2 add(Account2 account) {
		Session session = factory.getCurrentSession();
			System.out.println("account: "+account);
			session.save(account);
			System.out.println("save account: "+account);
			return account;
	}
}
