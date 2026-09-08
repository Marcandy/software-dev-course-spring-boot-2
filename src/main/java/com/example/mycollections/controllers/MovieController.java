package com.example.mycollections.controllers;

import com.example.mycollections.models.Movie;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/movies")
public class MovieController {

    private final List<Movie> movies = new ArrayList<>() {{
        add(new Movie("Inception", 2010, "Nolan", 125 ));
        add(new Movie("Titanic", 1998, "Paul", 136 ));
        add(new Movie("Odyssey", 2026, "Christopher", 140 ));
    }};


    @GetMapping("/json")
    public List<Movie> getMovies() { return movies; }

    @GetMapping("/html")
    public String getMovieHtml() {
       String movieList = "";

       for(Movie movie: movies) {
           movieList += "<li>" + movie + "</li>";
       }
        return """
               <html>
                   <body>
                       <h1>Movies</h1>
                       <ul>
               """ +
                    movieList +
                """
                        </ul>
                    </body>
                """;
    }
}
