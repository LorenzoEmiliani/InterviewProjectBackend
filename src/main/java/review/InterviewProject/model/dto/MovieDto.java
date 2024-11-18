package review.InterviewProject.model.dto;

import review.InterviewProject.model.Movie;
import review.InterviewProject.model.User;

public class MovieDto {
    
    private int id;
    private String title;
    private int viewCount;
    private User user;

    public MovieDto() {}
    
    public MovieDto(Movie movie) {
        this.id = movie.getId();
        this.title = movie.getTitle();
        this.viewCount = movie.getViewCount();
        this.user = movie.getUser();
    }

    public Movie toDto() {
        return new Movie(this.id, this.title, this.viewCount, this.user);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getViewCount() {
        return viewCount;
    }

    public void setViewCount(int viewCount) {
        this.viewCount = viewCount;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
