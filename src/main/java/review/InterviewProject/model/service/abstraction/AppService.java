package review.InterviewProject.model.service.abstraction;

import java.util.List;
import java.util.Optional;

import review.InterviewProject.model.Movie;
import review.InterviewProject.model.User;

public interface AppService {

    List<User> getAllUsers();
    Optional<User> getUserById(int id);
    User createUser(User user);
    User updateUser(int id, User user);
    void deleteUser(int id);

    List<Movie> getMoviesByUserId(int userId);
    Movie createMovie(Movie movie);
    Movie updateMovie(int id, Movie movie);
    Movie addViewById(int id);
    void deleteMovie(int id);

}
