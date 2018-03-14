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
import me.xstr.api.models.imdb.ImdbRating;
import me.xstr.api.services.ImdbRatingService;
import me.xstr.api.services.MovieService;
import me.xstr.api.services.TvShowService;

@RestController
public class MovieController {
	
	@Autowired
	MovieService movieService;
	@Autowired
	ImdbRatingService imdbRatingService;
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
    @GetMapping(value = "/tv/{id}")
	public TvShow tvshow(@PathVariable(value="id") int id) {
		return tvShowService.findOneById(id);
	}
	
	@CrossOrigin(origins = "*")
    @GetMapping(value = "/mv/{id}/info")
	public Movie fullMovie(@PathVariable(value="id") int id) {
		return movieService.findOneById(id);
	}
	
	@CrossOrigin(origins = "*")
    @GetMapping(value = "/mv/save")
	public ImdbRating saveMovie() {
		ImdbMedia imdbMedia = new ImdbMedia(328, MediaType.MOVIE,"cdcd","cqd",false,null,null,0,"");
		return imdbRatingService.saveImdbMedia(imdbMedia);
	}
	
	@CrossOrigin(origins = "*")
    @GetMapping(value = "/tv/save")
	public ImdbRating saveTvShow() {
		ImdbMedia imdbMedia = new ImdbMedia(329, MediaType.TV_SERIES,"cdcd","cqd",false,null,null,0,"");
		return imdbRatingService.saveImdbMedia(imdbMedia);
	}
	

}
