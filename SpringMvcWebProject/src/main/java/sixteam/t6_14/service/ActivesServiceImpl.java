package sixteam.t6_14.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sixteam.t6_14.model.Actives;
import sixteam.t6_14.model.ActivesDaoImpl;


@Transactional
@Service
public class ActivesServiceImpl implements ActiveService {

	@Autowired
	private ActivesDaoImpl actDao;

	
	public List<Actives> findAll() {
		List<Actives> active = actDao.findAll();
		return active;
	}

	
	public Actives findBId(Integer id) {
		Actives active = actDao.findById(id);
		return active;
	}

	
	public Boolean delete(Integer id) {

		Boolean result = actDao.delete(id);
		return result;
	}

	
	public Actives update(Actives active) {

		Actives result = actDao.update(active);
		return result;

	}

	
	public Actives insert(Actives active) {

		Actives result = actDao.insert(active);
		return result;

	}

}
