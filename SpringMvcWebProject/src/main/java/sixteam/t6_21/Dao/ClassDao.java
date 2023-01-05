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
	public ClassBean findById(int classId) {
		Session session=factory.openSession();
		
		ClassBean resultBean =session.get(ClassBean.class, classId);
		session.close();
		return resultBean;
	}
	
	
	//新增(單項新增)
	public ClassBean insert(ClassBean cBean) {
		Session session = factory.openSession();
		if(cBean != null) {
			session.save(cBean);
		}
		session.close();
		return cBean;
	}
	
	//更新單項
	public ClassBean update(ClassBean cBean) {
		Session session=factory.openSession();
		
		if(cBean != null) {
			session.update(cBean);
			//記得一定要加上flush強制執行(不然有可能寫不進資料庫)
			session.flush();
		}
		session.close();
		return cBean;
	}

	
	//刪除單項
	public boolean delete(ClassBean cBean) {
		Session session=factory.openSession();
		if(cBean != null) {
			session.delete(cBean);
			//記得一定要加上flush強制執行(不然有可能寫不進資料庫)
			session.flush();
			session.close();
			return true;
		}
		session.close();
		return false;
	}
	
	
}
