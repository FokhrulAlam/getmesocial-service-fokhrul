package com.fokhrul.PhotoSharing.resource;

import com.fokhrul.PhotoSharing.model.User;
import com.fokhrul.PhotoSharing.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/users")
public class UserResource {
    @Autowired
    private UserService userService;

    /**
     * Get a single user found by id
     * @return
     */
    @GetMapping(path = "/{userId}",produces = {
            MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE
            })
    public ResponseEntity<Optional<User>> getSingleUserById(@PathVariable("userId") String userId){
        return userService.getSingleUser(userId);
    }

    /**
     * Get 2 users found by their ids.
     * @return
     */
//    @GetMapping("{userId1}/{userId2}")
//    public ResponseEntity<List<Optional<User>>> getTwoUsersById(@PathVariable("userId1") String userId1,
//                                                                @PathVariable("userId2") String userId2){
//        return userService.getTwoUsersById(userId1, userId2);
//    }
    @GetMapping("{userId1}/{userId2}")
    public ResponseEntity<List<Optional<User>>> getTwoUsersById(@PathVariable Map<String, String>  userId){
        return userService.getTwoUsersById(userId);
    }

    /**
     * Get multiple users found by their ids.
     */


    /**
     * Get a single user found by user name
     */
    @GetMapping(path = "getOneByUserName/{userName}",produces = {
            MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE
            })
    public Optional<User> getSingleUserByName(@PathVariable("userName") String userName){
        return userService.getSingleUserByName(userName);
    }

    /**
     * Get a single user found by user email
     */
    @GetMapping(path = "getOneByEmail/{userEmail}",produces = {
            MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE
            })
    public Optional<User> getSingleUserByEmail(@PathVariable("userEmail") String userEmail){
        return userService.getSingleUserByEmail(userEmail);
    }

    /**
     * Get all users
     * @return
     */
    @GetMapping(produces = {
            MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE
            })
    public List<User> getUsers(){
        return userService.getUsers();
    }

    @PostMapping(consumes = {
            MediaType.APPLICATION_XML_VALUE,
            MediaType.APPLICATION_JSON_VALUE
            })
    public void saveUser(@Validated @RequestBody User user){
        userService.save(user);
    }

    /**
     * update all the attributes of a user except the id.
     * @param userId
     * @param user
     */
    @PutMapping(path = "editUserById/{userId}",consumes = {
            MediaType.APPLICATION_XML_VALUE,
            MediaType.APPLICATION_JSON_VALUE
            })
    public ResponseEntity<String> editUser(@RequestParam("userId") String userId, @Validated @RequestBody User user){

        if (userService.checkExistenceOfUserById(userId)) {
            userService.edit(userId, user);
            return new ResponseEntity<>("The user has been updated.", HttpStatus.ACCEPTED);
        }else {
            return new ResponseEntity<>("The user does not exist.", HttpStatus.NOT_FOUND);
        }

    }

    /**
     *update the email and the profilePhotoUrl only.
     */
    @PutMapping(path = "editEmailPhotoUrl/{userId}",consumes = {
            MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE
            })
    public void editUserEmailProfilePhotoUrl(@Validated @RequestBody User user, @PathVariable String userId){

        userService.editUserEmailProfilePhotoUrl(user);
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


//    /**
//     * Let's create a method for fallback for all four types of Mappings.
//     */
//    @RequestMapping(value = "*", method = {RequestMethod.GET, RequestMethod.POST,
//                                            RequestMethod.PUT, RequestMethod.DELETE})
//    public String allFallback(){
//        return  "Hi, speaking from the fallback method. Something is wrong!";
//    }



}
