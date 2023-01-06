package sixteam.t6_10.model;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import t6_10.bean.Account;
import t6_10.dao.AccountDao;
import t6_10.service.AccountService;
import tw.hibernatedemo.util.HibernateUtil;

public class AccountServiceImpl implements AccountManagerService {
	private AccountManagerDao accountDao;
	SessionFactory factory = HibernateUtil.getSessionFactory();

	public AccountServiceImpl() {
		accountDao = new AccountDaoImpl();
	}

	@Override
	public List<Account2> showAllAccount() {
		Session session = factory.getCurrentSession();
		try {
			session.beginTransaction();
			List<Account2> accountList = null;
			List<Account2> temp = accountDao.selectAll();
			if (temp != null) {
				accountList = temp;
			}
			session.getTransaction().commit();
			return accountList;
		} catch (Exception e) {
			System.out.println("RollBack(showAllAccount)");
			session.getTransaction().rollback();
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean removeAccount(int id) {
		Session session = factory.getCurrentSession();
		try {
			session.beginTransaction();
			boolean result = accountDao.delete(id);
			session.getTransaction().commit();
			return result;
		} catch (Exception e) {
			System.out.println("RollBack(removeAccount)");
			session.getTransaction().rollback();
			e.printStackTrace();
			return false;
		}

	}

	@Override
	public Account2 modify(Account2 account) {
		Session session = factory.getCurrentSession();
		try {
			session.beginTransaction();
			System.out.println(account);
			System.out.println("modify"+session);
			Account2 result = accountDao.update(account);
			session.getTransaction().commit();
			return result;
		} catch (Exception e) {
			System.out.println("RollBack(modify)");
			session.getTransaction().rollback();
			e.printStackTrace();
			return null;
		}

	}

	@Override
	public Account2 showAccount(int id) {
		Session session = factory.getCurrentSession();
		try {
			session.beginTransaction();
			Account2 account = accountDao.select(id);
			session.getTransaction().commit();
			return account;
		} catch (Exception e) {
			System.out.println("RollBack(showAccount)");
			session.getTransaction().rollback();
			e.printStackTrace();
			return null;
		}

	}

	@Override
	public Account2 add(Account2 account) {
		Session session = factory.getCurrentSession();
		try {
			session.beginTransaction();
			Account2 result = accountDao.add(account);
			System.out.println("result"+result);
			session.getTransaction().commit();
			return result;
		} catch (Exception e) {
			System.out.println("RollBack(add)");
			session.getTransaction().rollback();
			e.printStackTrace();
			return null;
		}

	}
}
