package com.fokhrul.PhotoSharing.repository;

import com.fokhrul.PhotoSharing.model.Photo;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface PhotoRepository extends MongoRepository<Photo, String> {

    /**
     * finding photos based on albumId
     * @param albumId
     * @return
     */
    Photo findByAlbumId(String albumId);

    /**
     * deleting a photo by an album id.
     * @param albumId
     */
    void deleteByAlbumId(String albumId);

}
