package sixteam.t6_21.Dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import sixteam.t6_21.model.ClassBean;

@Repository
@Transactional
public class ClassDao {
	@Autowired
	private SessionFactory factory;
	
	//查詢全部
	public List<ClassBean> selectAll() {
		Session session = factory.openSession();
		Query<ClassBean> query = session.createQuery("from ClassBean", ClassBean.class);
		List<ClassBean> result = query.getResultList();
		session.close();
		return result;
	}
	
	//查詢單項
	
	//新增
	public ClassBean insert(ClassBean cBean) {
		Session session = factory.openSession();
		if(cBean != null) {
			session.save(cBean);
		}
		session.close();
		return cBean;
	}
	
	
	
}
