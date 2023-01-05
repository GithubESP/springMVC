package sixteam.t6_14.model;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ActivesDaoImpl implements ActivesDao {
	@Autowired
	private SessionFactory factory;

	public List<Actives> findAll() {
		Session session = factory.getCurrentSession();
		String hql = "from Actives";
		Query<Actives> query = session.createQuery(hql, Actives.class);
		return query.getResultList();

	}

	public Actives findById(Integer id) {
		Session session = factory.getCurrentSession();
		return session.get(Actives.class, id);
	}

	public Boolean delete(Integer id) {

		Session session = factory.getCurrentSession();

		Actives active = session.get(Actives.class, id);
		if (active != null) {
			session.delete(active);
			return true;
		}
		return false;
	}

	public Actives update(Actives actives) {
		Session session = factory.getCurrentSession();

		Actives act = session.get(Actives.class, actives.getActiveID());
		if (act != null) {
			act.setActiveDescription(actives.getActiveDescription());
			act.setActiveEndDate(actives.getActiveEndDate());
			act.setActiveHost(actives.getActiveHost());
			act.setActiveImg(actives.getActiveImg());
			act.setActiveLocation(actives.getActiveLocation());
			act.setActiveStartDate(actives.getActiveStartDate());
			act.setActiveName(actives.getActiveName());
		}

		return act;
	}

	public Actives insert(Actives active) {
		Session session = factory.getCurrentSession();
		session.save(active);
		return active;
	}

}
