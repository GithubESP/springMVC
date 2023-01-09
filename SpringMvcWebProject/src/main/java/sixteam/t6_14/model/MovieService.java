package sixteam.t6_14.model;

import java.util.List;

public interface MovieService {
	public List<Movie> findAll();

	public Movie findById(Integer id);

	public Boolean delete(Integer id);

	public Movie update(Movie movies);

	public Movie save(Movie movie);
}
