package sixteam.t6_10.model;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class AccountDao {

	@Autowired
	private SessionFactory factory;

	//Finish
	public List<Account> selectAll() {
		Session session = factory.openSession();
		Query<Account> query = session.createQuery("from Account ORDER BY id ASC", Account.class);
		List<Account> result = query.getResultList();
		session.close();
		return result;
	}
	
	//Finish
	public boolean delete(Integer id) {
		Session session = factory.openSession();
		Account account = session.get(Account.class, id);

		if (account != null) {
			session.delete(account);
			session.flush();
			session.close();
			return true;
		}
		session.close();
		return false;
	}

	// Finish
	public Account update(Account account) {
		Session session = factory.openSession();

		if (account != null) {
			session.update(account);
			session.flush();
		}
		session.close();
		return account;
	}

	// Finish
	public Account select(Integer id) {
		Session session = factory.openSession();
		Account account = session.get(Account.class, id);
		session.close();
		return account;
	}

	// Finish
	public Account add(Account account) {
		Session session = factory.openSession();

		if (account != null) {
			session.save(account);
		}

		session.close();
		return account;
	}
}
