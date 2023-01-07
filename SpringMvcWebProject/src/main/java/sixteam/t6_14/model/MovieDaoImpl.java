package sixteam.t6_14.model;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MovieDaoImpl implements MovieDao{
	@Autowired
	private SessionFactory factory;

	@Override
	public List<Movie> findAll() {
		Session session = factory.getCurrentSession();
		String hql = "from Movie";
		Query<Movie> query = session.createQuery(hql, Movie.class);
		return query.getResultList();
		
	}

	@Override
	public Movie findById(Integer id) {
		Session session = factory.getCurrentSession();
		return session.get(Movie.class, id);
		
	}

	@Override
	public Boolean delete(Integer id) {
		
		Session session = factory.getCurrentSession();

		Movie movie = session.get(Movie.class, id);
		if (movie != null) {
			session.delete(movie);
			return true;
		}
		return false;
	}

	@Override
	public Movie update(Movie newMovie) {
		Session session = factory.getCurrentSession();

		Movie oldmovie = session.get(Movie.class, newMovie.getId());
		oldmovie.setName(newMovie.getName());
		oldmovie.setApplicant(newMovie.getApplicant());
		oldmovie.setCompany(newMovie.getCompany());
		oldmovie.setCountry(newMovie.getCountry());
		oldmovie.setDate(newMovie.getDate());
		oldmovie.setSales(newMovie.getSales());
		oldmovie.setSalesTicketNum(newMovie.getSalesTicketNum());
		oldmovie.setShowingNums(newMovie.getShowingNums());
		return oldmovie;
	}

	@Override
	public Movie save(Movie movie) {
		
		Session session = factory.getCurrentSession();
		session.save(movie);
		return movie;
	}

}
