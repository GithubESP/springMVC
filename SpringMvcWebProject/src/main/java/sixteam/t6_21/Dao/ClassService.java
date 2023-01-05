package sixteam.t6_21.Dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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

}
