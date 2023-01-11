package sixteam.t6_14.model;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import sixteam.t6_14.model.Actives;
import sixteam.t6_14.model.ActivesRepository;


@Transactional
@Service
public class ActivesServiceImpl implements ActiveService {

	@Autowired
	private ActivesRepository activesRepository;

	
	public List<Actives> findAll() {
	return	 activesRepository.findAll();
	
	}

	
	public Actives findById(Integer id) {
		Optional<Actives> optional = activesRepository.findById(id);
		return optional.get();
	}

	
	public void delete(Integer id) {

		 activesRepository.deleteById(id);
	}

	
	public Actives update(Actives active) {

		return activesRepository.save(active);
		

	}

	
	public Actives save(Actives active) {

		return activesRepository.save(active);
		

	}

}
