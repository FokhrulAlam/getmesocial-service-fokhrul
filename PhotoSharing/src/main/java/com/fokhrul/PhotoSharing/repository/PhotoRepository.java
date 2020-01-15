package com.fokhrul.PhotoSharing.repository;

import com.fokhrul.PhotoSharing.model.Photo;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface PhotoRepository extends MongoRepository<Photo, String> {
    /**
     * finding photos based on albumId
     * @param albumId
     * @return
     */
    Optional<Photo> findByAlbumId(String albumId);

    void deleteByAlbumId(String albumId);

}
