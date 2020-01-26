package io.javabrains.MovieCatalogService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.assertj.core.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


// @Bean annotation is used on top of any method, it execute that method and maps it to type 
// let say , there is method which return object foo, it says anybody which needs foo, I am going to 
// inject return of that method i.e foo
// @Bean annotation is producer - Autowire is consumer

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@RequestMapping("/{userid}")
	public List<CatalogItem> getMovieCatalog(@PathVariable("userid") String userid ){
	
		UserRating ratings = 
				restTemplate.getForObject("http:/movie-rating-service/ratingdata/users/" + userid , UserRating.class);
		
		    return ratings.getUserRating().stream().map(rating -> {
			// for all each movie Id, call movie info service and get Details
		    	Movie movie = restTemplate.getForObject("http:movie-info-service/movies/6", Movie.class);
			return new CatalogItem(movie.getName(), "batman", rating.getMovieRating());
		})
				.collect(Collectors.toList());
	}

}
