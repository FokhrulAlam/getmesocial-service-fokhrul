package com.fokhrul.PhotoSharing.repository;

import com.fokhrul.PhotoSharing.model.Album;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface AlbumRepository extends MongoRepository<Album, String> {

    Optional<Album> findByName(String name);

    boolean existsByCoverPhotoUrl(String coverPhotoUrl);

}
