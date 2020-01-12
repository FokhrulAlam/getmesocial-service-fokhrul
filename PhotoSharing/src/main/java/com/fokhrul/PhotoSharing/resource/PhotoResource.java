package com.fokhrul.PhotoSharing.resource;

import com.fokhrul.PhotoSharing.model.Photo;
import com.fokhrul.PhotoSharing.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/photos")
public class PhotoResource {
    @Autowired
    private PhotoService photoService;

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

    @PostMapping
    public void savePhoto(@RequestBody Photo photo){
        photoService.save(photo);
    }

    @PutMapping(path = "/{id}")
    public void editPhoto(@PathVariable("id") String id, @RequestBody Photo photo){
        photo.setPhotoId(id);
        photoService.edit(photo);
    }

    @DeleteMapping(path = "/{id}")
    public void deletePhoto(@PathVariable("id") String id){
        photoService.delete(id);
    }

    /**
     * Delete all photos
     */
    @DeleteMapping("/deleteAll")
    public void deleteAllPhotos(){
        photoService.deleteAllPhotos();
    }
}
