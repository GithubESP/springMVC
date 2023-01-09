package sixteam.t6_23.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sixteam.t6_23.Dao.PeopleDao_23;
import sixteam.t6_23.Dao.Impl.PeopleDaoImpl;
import sixteam.t6_23.bean.PeopleBean_23;
import sixteam.t6_23.service.PeopleService;

@Service
@Transactional
public class PeopleServiceImpl implements PeopleService {

	@Autowired
	private PeopleDao_23 peoDao;

	public PeopleServiceImpl() {
		this.peoDao = new PeopleDaoImpl();
	}

	@Override
	public List<PeopleBean_23> selectAll() {
			List<PeopleBean_23> selectAll = peoDao.selectAll();
			return selectAll;
	}

	@Override
	public PeopleBean_23 selectById(Integer id) {
			PeopleBean_23 selectById = peoDao.selectById(id);
			return selectById;
	}

	@Override
	public boolean delete(Integer id) {
			boolean delete = peoDao.delete(id);
			return delete;
	}

	@Override
	public PeopleBean_23 update(PeopleBean_23 bean) {
			PeopleBean_23 update = peoDao.update(bean);
			return update;
	}

	@Override
	public void save(PeopleBean_23 bean) {
			peoDao.save(bean);
	}

	@Override
	public PeopleBean_23 findImageById(Integer Id) {
			PeopleBean_23 findImageById = peoDao.findImageById(Id);
			return findImageById;
	}

	@Override
	public List<PeopleBean_23> selectByName(String name) {
			List<PeopleBean_23> selectByName = peoDao.selectByName(name);
			return selectByName;
	}

}
