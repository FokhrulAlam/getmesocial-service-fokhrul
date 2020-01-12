package com.fokhrul.PhotoSharing.service;

import com.fokhrul.PhotoSharing.model.User;
import com.fokhrul.PhotoSharing.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    /**
     * get a single user found by id
     * @param userId
     */
    public Optional<User> getSingleUser(String userId) {
       return userRepository.findById(userId);
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

    public void edit(User user) {
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


}
