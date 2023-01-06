package sixteam.t6_14.controller;

import java.util.List;

import javax.servlet.annotation.MultipartConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sixteam.t6_14.model.Actives;
import sixteam.t6_14.service.ActiveService;
@MultipartConfig
@RestController
@RequestMapping("/actives")
public class ActiveController {
	@Autowired
	private ActiveService activeService;
@PostMapping
	public Actives save(@RequestBody Actives active) {

		Actives result = activeService.save(active);
		return result;

	}
@DeleteMapping("/{id}")
	public Boolean delete(@PathVariable Integer id) {

		Boolean result = activeService.delete(id);
		return result;
	}
@PutMapping
	public Actives update(@RequestBody Actives active) {

		Actives result = activeService.update(active);
		return result;

	}
@GetMapping
	public List<Actives> findAll() {
		List<Actives> active = activeService.findAll();
		return active;
	}
@GetMapping("/{id}")
	public Actives findById(@PathVariable Integer id) {
		Actives active = activeService.findById(id);
		return active;
	}

}
