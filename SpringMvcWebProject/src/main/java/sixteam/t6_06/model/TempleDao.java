package sixteam.t6_06.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class TempleDao {
	@Autowired
	private SessionFactory factory;
	
	//搜尋
	public TempleBean findById(String templeId) {
		Session session = factory.openSession();
		
		TempleBean tmpb = session.get(TempleBean.class, templeId);
		
		session.close();
		return tmpb;
	}

	//新增
	public TempleBean insertTemple(TempleBean tmpb) {
		Session session = factory.openSession();
		session.save(tmpb);

		return null;
	}
	
	//更改
	public TempleBean updateOneTemple(TempleBean tmpb) {
		Session session = factory.openSession();
		
		TempleBean tmpBean = session.get(TempleBean.class, tmpb.getTempleId());
		if(tmpBean != null) {
			tmpBean.setTempleName(tmpb.getTempleName());
			tmpBean.setDeitiesName(tmpb.getDeitiesName());
			tmpBean.setAdministrative(tmpb.getAdministrative());
			tmpBean.setAddress(tmpb.getAddress());
			tmpBean.setRegister(tmpb.getRegister());
			tmpBean.setSect(tmpb.getSect());
			tmpBean.setPhone(tmpb.getPhone());
			tmpBean.setPrincipal(tmpb.getPrincipal());
			tmpBean.setOther(tmpb.getOther());
			tmpBean.setWGS84X(tmpb.getWGS84X());
			tmpBean.setWGS84Y(tmpb.getWGS84Y());
			tmpBean.setUniformnumbers(tmpb.getUniformnumbers());
			session.getTransaction().commit();
		}
		
		return tmpBean;
	}
	
	//刪除
	public void deleteTemple(String templeId) {
		Session session = factory.getCurrentSession();
		TempleBean tmpBean = session.get(TempleBean.class, templeId);
		
		if(tmpBean != null) {
			session.delete(tmpBean);
		}
	}
	
	//找全部
//	public List<TempleBean> sellectAll() {
//		Session session = factory.openSession();
//		try {
//			Query<TempleBean> query = session.createQuery("from TempleBean order by templeId", TempleBean.class);
//			List<TempleBean> beans = query.getResultList();
//			return beans;
//		}catch(Exception e) {
//			session.getTransaction().rollback();
//			e.printStackTrace();
//		}finally {
//			HibernateUtil.closeSessionFactory();
//		}
//		return null;
//	}
}
