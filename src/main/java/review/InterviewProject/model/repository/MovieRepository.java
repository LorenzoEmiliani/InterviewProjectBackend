package review.InterviewProject.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import review.InterviewProject.model.Movie;

public interface MovieRepository extends JpaRepository<Movie, Integer> {
    
    List<Movie> findByUserId(int userId);
    
}
