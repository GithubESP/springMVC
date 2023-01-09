package sixteam.t6_06.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TempleService {
	
	@Autowired
	private TempleDao tDao;
	
	public TempleBean findById(String templeId) {
		return tDao.findById(templeId);
	}
	
	public TempleBean insertTemple(TempleBean tmpb) {
		return tDao.insertTemple(tmpb);
	}
	
	public TempleBean updateOneTemple(TempleBean tmpb) {
		return tDao.updateOneTemple(tmpb);
	}
	
	public void deleteTemple(String templeId) {
		tDao.deleteTemple(templeId);
	}
	
	public List<TempleBean> sellectAll() {
		return tDao.sellectAll();
	}
}
