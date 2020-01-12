package com.fokhrul.PhotoSharing.resource;

import com.fokhrul.PhotoSharing.model.User;
import com.fokhrul.PhotoSharing.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserResource {
    @Autowired
    private UserService userService;

    /**
     * Get a single user found by id
     * @return
     */
    @GetMapping(path = "/{userId}")
    public Optional<User> getSingleUser(@PathVariable("userId") String userId){
        return userService.getSingleUser(userId);
    }

    /**
     * Get all users
     * @return
     */
    @GetMapping
    public List<User> getUsers(){
        return userService.getUsers();
    }

    @PostMapping
    public void saveUser(@RequestBody User user){
        userService.save(user);
    }

    @PutMapping(path = "/{id}")
    public void editUser(@PathVariable("id") String id, @RequestBody User user){
        user.setId(id);
        userService.edit(user);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteAlbum(@PathVariable("id") String id){
        userService.delete(id);
    }

    /**
     * Delete all users
     */
    @DeleteMapping("/deleteAll")
    public void deleteAllUsers(){
        userService.deleteAllUsers();
    }
}
