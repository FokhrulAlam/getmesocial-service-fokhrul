package com.fokhrul.PhotoSharing.resource;

import com.fokhrul.PhotoSharing.exception.customeExceptionHandler.InvalidAlbumIdException;
import com.fokhrul.PhotoSharing.model.Photo;
import com.fokhrul.PhotoSharing.service.AlbumService;
import com.fokhrul.PhotoSharing.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/photos")
public class PhotoResource {
    @Autowired
    private PhotoService photoService;

    @Autowired
    private AlbumService albumService;

    /**
     * Get a single photo found by id
     * @return
     */
    @GetMapping(path = "/{photoId}")
    public Optional<Photo> getSinglePhoto(@PathVariable("photoId") String photoId){
        return photoService.getSinglePhoto(photoId);
    }

    /**
     * Get all photos
     * @return
     */
    @GetMapping
    public List<Photo> getPhoto(){
        return photoService.getPhoto();
    }

    /**
     * Save a photo in the repository.
     * @param photo
     */
    @PostMapping
    public void savePhoto(@Validated @RequestBody Photo photo){
        //check whether the albumId exists in the AlbumRepository or not. If not, throw an exception.
        if(albumService.checkExistenceOfAlbumId(photo.getAlbumId())){
            photoService.save(photo);
        }else{
            throw new InvalidAlbumIdException();
        }

    }

    @PutMapping(path = "/{photoId}")
    public void editPhoto(@PathVariable("photoId") String id, @Validated @RequestBody Photo photo){
        photo.setPhotoId(id);
        photoService.edit(photo);
    }

    @DeleteMapping(path = "deleteSinglePhotoByPhotoId/{photoId}")
    public void deletePhoto(@PathVariable("photoId") String id){
        photoService.delete(id);
    }

    /**
     * Delete all photos
     */
    @DeleteMapping("/deleteAllPhotos")
    public void deleteAllPhotos(){
        photoService.deleteAllPhotos();
    }
}
