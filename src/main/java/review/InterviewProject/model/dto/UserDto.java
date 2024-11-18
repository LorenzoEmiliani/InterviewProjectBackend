package review.InterviewProject.model.dto;

import review.InterviewProject.model.User;

public class UserDto {
    
    private int id;
    private String name;

    public UserDto() {}
    
    public UserDto(User user) {
        this.id = user.getId();
        this.name = user.getName();
    }

    public User toDto() {
        return new User(this.id, this.name);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
