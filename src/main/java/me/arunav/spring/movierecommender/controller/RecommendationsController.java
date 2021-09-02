package me.arunav.spring.movierecommender.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import me.arunav.spring.movierecommender.data.Movie;

import java.util.Arrays;
import java.util.List;

@RestController
public class RecommendationsController {

    @GetMapping("/movies")
//    @RequestMapping(method = RequestMethod.GET, value = "/movies")
    public List<Movie> getMovies() {
        return Arrays.asList(new Movie(1, "Ice Age", 7.5),
                new Movie(2, "Happy Feet", 6.4),
                new Movie(3, "Happy Hands", 9.4),
                new Movie(4, "Finding Dory", 8.4),
                new Movie(5, "Shark Tales", 6.0));
    }
}
