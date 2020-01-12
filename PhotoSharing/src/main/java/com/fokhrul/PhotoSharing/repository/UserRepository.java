package com.fokhrul.PhotoSharing.repository;

import com.fokhrul.PhotoSharing.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String> {
    /**
     * returns a single user found by id
     * @param s
     * @return
     */
    @Override
    Optional<User> findById(String s);
}
