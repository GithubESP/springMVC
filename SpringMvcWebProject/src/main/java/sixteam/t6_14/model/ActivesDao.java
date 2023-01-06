package sixteam.t6_14.model;

import java.util.List;

public interface ActivesDao {

	public List<Actives> findAll();

	public Actives findById(Integer id);

	public Boolean delete(Integer id);

	public Actives update(Actives actives);

	public Actives save(Actives active);

}
