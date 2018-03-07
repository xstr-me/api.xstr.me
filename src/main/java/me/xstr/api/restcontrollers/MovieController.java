package me.xstr.api.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import me.xstr.api.models.MediaType;
import me.xstr.api.models.Movie;
import me.xstr.api.models.TvShow;
import me.xstr.api.models.imdb.ImdbMedia;
import me.xstr.api.services.MovieService;
import me.xstr.api.services.TvShowService;

@RestController
public class MovieController {
	
	@Autowired
	MovieService movieService;
	@Autowired
	private TvShowService tvShowService;
	
	@CrossOrigin(origins = "*")
    @GetMapping(value = "/mv/list")
	public List<Movie> xstrMovieList() {
		return movieService.findAll();
	}
	
	@CrossOrigin(origins = "*")
    @GetMapping(value = "/mv/{id}")
	public Movie movie(@PathVariable(value="id") int id) {
		return movieService.findOneById(id);
	}
	
	@CrossOrigin(origins = "*")
    @GetMapping(value = "/mv/{id}/info")
	public Movie fullMovie(@PathVariable(value="id") int id) {
		return movieService.findOneById(id);
	}
	
	@CrossOrigin(origins = "*")
    @GetMapping(value = "/mv/save")
	public Movie saveMovie() {
		ImdbMedia imdbMedia = new ImdbMedia(3, MediaType.MOVIE,"cdcd","cqd",false,null,null,0,"");
		return movieService.saveImdbMovie(imdbMedia);
	}
	
	@CrossOrigin(origins = "*")
    @GetMapping(value = "/tv/save")
	public TvShow saveTvShow() {
		ImdbMedia imdbMedia = new ImdbMedia(2, MediaType.TVSHOW,"cdcd","cqd",false,null,null,0,"");
		return tvShowService.saveImdbTvShow(imdbMedia);
	}
	

}
