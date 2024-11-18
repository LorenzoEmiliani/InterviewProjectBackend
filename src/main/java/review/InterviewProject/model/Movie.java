package review.InterviewProject.model;

import jakarta.persistence.*;

@Entity
@Table(name = "movie")
public class Movie {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "title", nullable = false)
    private String title;
    @Column(name = "view_count", nullable = false)
    private int viewCount;
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public Movie() {}
    
    public Movie(int id, String title, int viewCount, User user) {
        this.id = id;
        this.title = title;
        this.viewCount = viewCount;
        this.user = user;
    }

    public int getId() {
        return id;
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

}