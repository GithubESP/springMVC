package sixteam.t6_23.Dao.Impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import sixteam.t6_23.Dao.PeopleDao_23;
import sixteam.t6_23.bean.PeopleBean_23;

@Repository
@Transactional
public class PeopleDaoImpl implements PeopleDao_23 {

	@Autowired
	private SessionFactory factory;
	
	@Override
	public List<PeopleBean_23> selectAll() {
		Session session = factory.openSession();
		
		Query<PeopleBean_23> query = session.createQuery("from PeopleBean_23", PeopleBean_23.class);
		
		List<PeopleBean_23> result = query.getResultList();
	
		session.close();
		
		return result;
		
	}

	@Override
	public PeopleBean_23 selectById(Integer id) {
		Session session = factory.openSession();
		PeopleBean_23 result = session.get(PeopleBean_23.class, id);
		session.close();
		return result;
		
	}

	@Override
	public boolean delete(Integer id) {
		Session session = factory.openSession();
		
		PeopleBean_23 peoBean = session.get(PeopleBean_23.class, id);
		
		
		if(peoBean!=null) {
			session.delete(peoBean);
			session.flush();
			session.close();
			return true;
		}
		session.close();
		return false;
		
	}

	@Override
	public PeopleBean_23 update(PeopleBean_23 bean) {
		Session session = factory.openSession();
		
		PeopleBean_23 peoBean = session.get(PeopleBean_23.class, bean.getUserID());
		
//		if(peoBean.getUserID()!=null) {
			peoBean.setName(bean.getName());
			peoBean.setAge(bean.getAge());
			peoBean.setAddress(bean.getAddress());
			peoBean.setStar(bean.getStar());
			peoBean.setEmotion(bean.getEmotion());
			peoBean.setProfession(bean.getProfession());
			peoBean.setPersonality(bean.getPersonality());
			peoBean.setHobby(bean.getHobby());
			peoBean.setDream(bean.getDream());
			peoBean.setIntroduction(bean.getIntroduction());
			peoBean.setImages(bean.getImages());
			peoBean.setReligion(bean.getReligion());
			peoBean.setSex_in(bean.getSex_in());
			peoBean.setIncome(bean.getIncome());
			session.flush();
			session.close();
			
		return peoBean;
		
	}

	@Override
	public void save(PeopleBean_23 bean) {
		Session session = factory.openSession();
		
//		PeopleBean_23 peoBean = session.get(PeopleBean_23.class, bean.getUserID());
		
		if(bean!=null) {
			session.save(bean);
			session.flush();
			System.out.println(bean.getAddress());
			System.out.println("666666666666666666666666");
		}
		session.close();
	}

	@Override
	public PeopleBean_23 findImageById(Integer Id) {
		String hql = "select pb.Images from PeopleBean_23 pb where pb.userID = :Id";
		Session session = factory.openSession();
		
		PeopleBean_23 result = session.createQuery(hql, PeopleBean_23.class)
		.setParameter("Id", Id)
		.getSingleResult();
		session.close();
		return result;
		
	}

	@Override
	public List<PeopleBean_23> selectByName(String name) {
		String hql = "from PeopleBean_23 pb where pb.Name like :name";
		Session session = factory.openSession();
		
		List<PeopleBean_23> result = session.createQuery(hql, PeopleBean_23.class)
				.setParameter("name", "%"+name+"%")
				.getResultList();
		session.close();
		return result;
		
	}

}
