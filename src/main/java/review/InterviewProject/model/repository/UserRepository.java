package review.InterviewProject.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import review.InterviewProject.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {}
