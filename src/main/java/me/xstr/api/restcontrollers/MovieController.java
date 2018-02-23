package me.xstr.api.restcontrollers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import me.xstr.api.models.Movie;
import me.xstr.api.models.XstrMovie;
import me.xstr.api.services.MovieService;

@RestController
public class MovieController {
	
	@Autowired
	MovieService movieService;
	
	@CrossOrigin(origins = "*")
    @GetMapping(value = "/mv/list")
	public List<XstrMovie> xstrMovieList(
			@RequestParam(value="name", defaultValue="World") String name
			) {
		ArrayList<XstrMovie> tempList = new ArrayList<>();
		tempList.add(new XstrMovie(0, "sfds", "dsd"));
		tempList.add(new XstrMovie(1, "sfds", "dsd"));
		tempList.add(new XstrMovie(2, "sfds", "dsd"));
		tempList.add(new XstrMovie(3, "sfds", "dsd"));
		return tempList;
	}
	
	@CrossOrigin(origins = "*")
    @GetMapping(value = "/mv/{id}")
	public Movie movie(@PathVariable(value="id") int id) {
		return movieService.findOneById(id);
	}
	

}
