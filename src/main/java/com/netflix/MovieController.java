package com.netflix;


import com.netflix.model.MovieMatch;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/movie")
public class MovieController {

    final private MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }


    @GetMapping("/search")
    public List<MovieMatch> search(@RequestParam String query) {
      return  movieService.search(query);

    }



    @GetMapping("/{title}/similar")
    public List<MovieMatch> similarMovies(@PathVariable String title) {
        return movieService.similarMovies(title);
    }


}
