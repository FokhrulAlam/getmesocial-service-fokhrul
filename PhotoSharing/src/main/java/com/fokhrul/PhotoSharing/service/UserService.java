package com.fokhrul.PhotoSharing.service;

import com.fokhrul.PhotoSharing.exception.GlobalExceptionHandler;
import com.fokhrul.PhotoSharing.model.User;
import com.fokhrul.PhotoSharing.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    /**
     * get a single user found by id
     * @param userId
     * @return
     */
    public ResponseEntity<Optional<User>> getSingleUser(String userId) {
        if (userRepository.existsById(userId)) {
            return new ResponseEntity<Optional<User>>(userRepository.findById(userId), HttpStatus.FOUND);
        }else{
            return new ResponseEntity<Optional<User>>(HttpStatus.NO_CONTENT);
        }
    }

    /**
     * Get 2 users found by their ids.
     * Here we will return a list of two users.
     */
//    public ResponseEntity<List<Optional<User>>> getTwoUsersById(String userId1, String userId2) {
//
//        List<Optional<User>> userList = new LinkedList<>();
//        userList.add(userRepository.findById(userId1));
//        userList.add(userRepository.findById(userId2));
//        return new ResponseEntity<List<Optional<User>>>(userList,HttpStatus.OK);
//    }
    public ResponseEntity<List<Optional<User>>> getTwoUsersById(Map<String, String> userId) {
        Collection<String> id = userId.values();

        List<Optional<User>> userList = new LinkedList<>();
        for (String idOfUser : id) {
            userList.add(userRepository.findById(idOfUser));
        }
        return new ResponseEntity<List<Optional<User>>>(userList,HttpStatus.OK);
    }

    /**
     * Get a single user found by user name
     */
    public Optional<User> getSingleUserByName(String userName) {
        return userRepository.findByName(userName);
    }

    /**
     * Get a single user found by user email
     */
    public Optional<User> getSingleUserByEmail(String userEmail) {
        return userRepository.findByEmail(userEmail);
    }

    /**
     * Get all users
     * @return
     */
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public void save(User user) {
        userRepository.save(user);
    }

    /**
     * Update a single user.
     * @param user
     * @return
     */
    public void edit(String userId, User user) {

//        //check the validity of the userId first.
//        if (userRepository.existsById(userId) == true) {
//            user.setId(userId);
//            return userRepository.save(user);
//        }else {
//            return null;
//        }
        user.setId(userId);
        userRepository.save(user);


    }

    public void delete(String id) {
        userRepository.deleteById(id);
    }

    /**
     * delete all users.
     */
    public void deleteAllUsers() {
        userRepository.deleteAll();
    }

    /**
     *update the email and the profilePhotoUrl only.
     */
    public void editUserEmailProfilePhotoUrl(User user) {

    }

    /**
     * Check whether the user exists in the collection using the userId.
     * @param userId
     * @return
     */
    public boolean checkExistenceOfUserById(String userId) {
        return userRepository.existsById(userId);
    }

    /**
     * Check whether the profilePhotoUrl has already been used or not.
     * @param profilePhotoUrl is the URL of the profile photo
     * @return a boolean value
     */
    public boolean checkExistenceOfProfilePhotoUrl(String profilePhotoUrl) {
        return userRepository.existsByProfilePhotoUrl(profilePhotoUrl);
    }

    /**
     * Check whether the email address is already used or not.
     * @param userEmail
     * @return
     */
    public boolean checkExistenceOfEmailAddress(String userEmail) {
        return userRepository.existsByEmail(userEmail);
    }


}
