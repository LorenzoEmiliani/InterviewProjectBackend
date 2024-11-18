package review.InterviewProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import review.InterviewProject.model.User;
import review.InterviewProject.model.dto.UserDto;
import review.InterviewProject.model.service.abstraction.AppService;

@RestController
public class UserController {

    private AppService appService;

    @Autowired
    public UserController(AppService appService) {
        this.appService = appService;
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUsers() {
        List<User> allUsers = appService.getAllUsers();
        if(allUsers.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(allUsers.stream().map(u -> new UserDto(u)).toList());
    }

    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {
        User createdUser = appService.createUser(userDto.toDto());
        return ResponseEntity.status(HttpStatus.CREATED).body(new UserDto(createdUser));
    }

    @PutMapping("/{userId}")
    public ResponseEntity<UserDto> updateUser(@PathVariable("userId") int userId, @RequestBody UserDto userDto){
        User updatedUser = appService.updateUser(userId, userDto.toDto());
        return ResponseEntity.ok(new UserDto(updatedUser));
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable("userId") int userId){
        appService.deleteUser(userId);
        return ResponseEntity.noContent().build();
    }
  
}
