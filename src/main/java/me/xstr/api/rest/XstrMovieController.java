package me.xstr.api.rest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import me.xstr.api.domain.TmdbMovie;
import me.xstr.api.domain.XstrMovie;
import me.xstr.api.services.TmdbMovieService;

@RestController
public class XstrMovieController {
	
	@Autowired
	TmdbMovieService tmdbMovieService;
	
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
	public XstrMovie xstrMovie(@PathVariable(value="id") long id) {
		return new XstrMovie(id, "sfds", "dsd");
	}
	
	@CrossOrigin(origins = "*")
    @GetMapping(value = "/tmdb/{id}")
	public TmdbMovie tmdbMovie(@PathVariable(value="id") int id) {
		return tmdbMovieService.findOneById(id);
	}
	

}
