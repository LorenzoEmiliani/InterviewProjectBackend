package review.InterviewProject.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import review.InterviewProject.model.Movie;
import review.InterviewProject.model.User;
import review.InterviewProject.model.dto.MovieDto;
import review.InterviewProject.model.service.abstraction.AppService;

@RestController
@RequestMapping("{userId}/movies")
public class MovieController {

    private AppService appService;

    @Autowired
    public MovieController(AppService appService) {
        this.appService = appService;
    }

    @GetMapping
    public ResponseEntity<List<MovieDto>> getMovies(@PathVariable("userId") int userId){
        List<Movie> movies = appService.getMoviesByUserId(userId);
        if(movies.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(movies.stream().map(m -> new MovieDto(m)).toList());
    }

    @PostMapping
    public ResponseEntity<MovieDto> createMovie(@PathVariable("userId") int userId, @RequestBody MovieDto movieDto){
        Optional<User> optUser = appService.getUserById(userId);
        movieDto.setUser(optUser.get());
        Movie createdMovie = appService.createMovie(movieDto.toDto());
        return ResponseEntity.status(HttpStatus.CREATED).body(new MovieDto(createdMovie));
    }

    @PutMapping("/{movieId}")
    public ResponseEntity<MovieDto> updateMovie(@PathVariable("movieId") int movieId, @RequestBody MovieDto movieDto){
        Movie updatedMovie = appService.updateMovie(movieId, movieDto.toDto());
        return ResponseEntity.ok(new MovieDto(updatedMovie));
    }

    @PutMapping("/{movieId}/view")
    public ResponseEntity<MovieDto> addView(@PathVariable("movieId") int movieId){
        Movie addedViewMovie = appService.addViewById(movieId);
        return ResponseEntity.ok(new MovieDto(addedViewMovie));
    }

    @DeleteMapping("/{movieId}")
    public ResponseEntity<Void> deleteMovie(@PathVariable("movieId") int movieId){
        appService.deleteMovie(movieId);
        return ResponseEntity.noContent().build();
    }

}
