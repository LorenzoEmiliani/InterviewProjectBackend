package review.InterviewProject.model.service.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import review.InterviewProject.model.Movie;
import review.InterviewProject.model.User;
import review.InterviewProject.model.repository.MovieRepository;
import review.InterviewProject.model.repository.UserRepository;
import review.InterviewProject.model.service.abstraction.AppService;

@Service
public class AppServiceImplementation implements AppService {
    
    private UserRepository userRepo;
    private MovieRepository movieRepo;

    @Autowired
    public AppServiceImplementation(UserRepository userRepo, MovieRepository movieRepo) {
        this.userRepo = userRepo;
        this.movieRepo = movieRepo;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    @Override
    public Optional<User> getUserById(int id) {
        return userRepo.findById(id);
    }

    @Override
    public User createUser(User user) {
        return userRepo.save(user);
    }

    @Override
    public User updateUser(int id, User user) {
        User existingUser = userRepo.findById(id).get();
        existingUser.setName(user.getName());
        return userRepo.save(existingUser);
    }
    
    @Override
    public void deleteUser(int id) {
        userRepo.deleteById(id);
    }

    @Override
    public List<Movie> getMoviesByUserId(int userId) {
        return movieRepo.findByUserId(userId);
    }

    @Override
    public Movie createMovie(Movie movie) {
        return movieRepo.save(movie);
    }

    @Override
    public Movie updateMovie(int id, Movie movie) {
        Movie existingMovie = movieRepo.findById(id).get();
        existingMovie.setTitle(movie.getTitle());
        return movieRepo.save(existingMovie);
    }

    @Override
    public Movie addViewById(int id) {
        Movie movie = movieRepo.findById(id).get();
        int actualView = movie.getViewCount();
        movie.setViewCount(++actualView);
        return movieRepo.save(movie);
    }

    @Override
    public void deleteMovie(int id) {
        movieRepo.deleteById(id);
    }

}
