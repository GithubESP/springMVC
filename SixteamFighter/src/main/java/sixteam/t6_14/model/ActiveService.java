package sixteam.t6_14.model;

import java.util.List;

import sixteam.t6_14.model.Actives;



public interface ActiveService {
	public List<Actives> findAll();
	
	
	public Actives findById(Integer id) ;
	
	
	public void delete(Integer id) ;
	
	
	public Actives update(Actives active);
	
	
	public Actives save(Actives active) ;
	
}
