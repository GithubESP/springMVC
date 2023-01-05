package sixteam.t6_14.service;

import java.util.List;

import sixteam.t6_14.model.Actives;



public interface ActiveService {
	public List<Actives> findAll();
	
	
	public Actives findById(Integer id) ;
	
	
	public Boolean delete(Integer id) ;
	
	
	public Actives update(Actives active);
	
	
	public Actives insert(Actives active) ;
	
}
