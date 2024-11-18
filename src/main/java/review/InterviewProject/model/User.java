package review.InterviewProject.model;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "app_user")
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name", nullable = false)
    private String name;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Movie> movie;

    public User() {}
    
    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    } 
    
}
