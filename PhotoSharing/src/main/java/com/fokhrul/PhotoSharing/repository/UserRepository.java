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

    /**
     *
     * @param userName
     * @return      a single user found by user name
     */
    Optional<User> findByName(String userName);

    /**
     *
     * @param userEmail
     * @return      a single user found by email address
     */
//    @Query("{'User.email':?0}")
    Optional<User> findByEmail(String userEmail);

    Optional<User> findByProfilePhotoUrl(String photoUrl);

    boolean existsByName(String name);
    boolean existsByEmail(String email);
    boolean existsByProfilePhotoUrl(String profilePhotoUrl);
}
