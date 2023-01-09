package sixteam.t6_14.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sixteam.t6_14.model.Movie;
import sixteam.t6_14.model.MovieService;
@RestController
@RequestMapping("/movie")
public class MovieController {
		@Autowired
		private MovieService movieService;
	@PostMapping
		public Movie save(@RequestBody Movie movie) {

			Movie result = movieService.save(movie);
			return result;

		}
	@DeleteMapping("/{id}")
		public Boolean delete(@PathVariable Integer id) {

			Boolean result = movieService.delete(id);
			return result;
		}
	@PutMapping
		public Movie update(@RequestBody Movie active) {

			Movie result = movieService.update(active);
			return result;

		}
	@GetMapping
		public List<Movie> findAll() {
			List<Movie> active = movieService.findAll();
			return active;
		}
	@GetMapping("/{id}")
		public Movie findById(@PathVariable Integer id) {
			Movie active = movieService.findById(id);
			return active;
		}


}
