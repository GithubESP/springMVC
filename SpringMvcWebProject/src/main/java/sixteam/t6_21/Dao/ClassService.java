package sixteam.t6_21.Dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import sixteam.t6_21.model.ClassBean;

@Service
@Transactional
public class ClassService {
	@Autowired
	private ClassDao cDao;
	
	public List<ClassBean> selectAll(){
		return cDao.selectAll();
	}
	public ClassBean findById(int classId) {
		return cDao.findById(classId);
	}
	public ClassBean insert(ClassBean cBean) {
		return cDao.insert(cBean);
	}
	
	public ClassBean update(ClassBean cBean) {
		return cDao.update(cBean);
	}

	public boolean delete(ClassBean cBean) {
		return cDao.delete(cBean);
	}


}
