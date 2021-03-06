package com.fokhrul.PhotoSharing.service;

import com.fokhrul.PhotoSharing.model.Photo;
import com.fokhrul.PhotoSharing.repository.PhotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PhotoService {
    @Autowired
    PhotoRepository photoRepository;


    /**
     * Get a single photo found by photo id
     * @param photoId
     * @return
     */
    public Optional<Photo> getSinglePhoto(String photoId) {
        return photoRepository.findById(photoId);
    }

    /**
     * Get a single photo by album id
     * @param albumId
     * @return
     */
    public Photo getSinglePhotoByAlbumId(String albumId) {
        return photoRepository.findByAlbumId(albumId);
    }

    /**
     * Get all photos
     * @return
     */
    public List<Photo> getPhoto()
    {
        return photoRepository.findAll();
    }

    public void save(Photo photo) {
        photoRepository.save(photo);
    }

    public void edit(Photo photo) {
        photoRepository.save(photo);
    }

    public void delete(String id) {
        photoRepository.deleteById(id);
    }

    /**
     * delete all photos
     */
    public void deleteAllPhotos() {
        photoRepository.deleteAll();
    }

    /**
     * Delete the photo by albumId
     * @param albumId
     */
    public void deleteByAlbumId(String albumId) {
        photoRepository.deleteByAlbumId(albumId);
    }


    public boolean checkExistenceByPhotoId(String photoId) {
        return photoRepository.existsById(photoId);
    }
}
