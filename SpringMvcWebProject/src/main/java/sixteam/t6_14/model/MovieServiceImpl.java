package sixteam.t6_14.model;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
@Transactional
public class MovieServiceImpl implements MovieService{
	@Autowired
	private MovieDao movieDao;

	@Override
	public List<Movie> findAll() {
		List<Movie> movies = movieDao.findAll();
		return movies;
	}

	@Override
	public Movie findById(Integer id) {
		Movie movie = movieDao.findById(id);
		return movie;
	}

	@Override
	public Boolean delete(Integer id) {
		Boolean result = movieDao.delete(id);
		return result;

	}

	@Override
	public Movie update(Movie movies) {
		Movie result = movieDao.update(movies);
		return result;

	}

	@Override
	public Movie save(Movie movie) {
		Movie result = movieDao.save(movie);
		return result;
	}

}
