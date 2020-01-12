package com.fokhrul.PhotoSharing.resource;

import com.fokhrul.PhotoSharing.model.Album;
import com.fokhrul.PhotoSharing.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/albums")
public class AlbumResource {
    @Autowired
    private AlbumService albumService;

    /**
     * Get a single album found by an id.
     */
    public Optional<Album> getSingleAlbum(String albumId) {
        return albumService.getSingleAlbum(albumId);
    }

    /**
     * Gell all albums.
     * @return
     */
    @GetMapping
    public List<Album> getAlbums(){
        return albumService.getAlbums();
    }

    @PostMapping
    public void saveAlbum(@RequestBody Album album){
        albumService.save(album);
    }

    /**
     * Update a single album
     * @param albumId
     * @param album
     */
    @PutMapping(path = "/{albumId}")
    public void editAlbum(@PathVariable("albumId") String albumId, @RequestBody Album album){
        album.setId(albumId);
        albumService.edit(album);
    }

    /**
     * Delete a single album
     * @param id
     */
    @DeleteMapping(path = "/{id}")
    public void deleteAlbum(@PathVariable("id") String id){
        albumService.delete(id);
    }

    /**
     * Delete all albums
     */
    @DeleteMapping("/deleteAll")
    public void deleteAllAlbums(){
        albumService.deleteAllAlbums();
    }

    /**
     * Now, if we delete an album, all photos of that album will be deleted too.
     */
    @DeleteMapping("/dWithPhotos/{albumId}")
    public void deleteAlbumWithPhotos(@PathVariable("albumId") String albumId){
        albumService.deleteAlbumWithPhotos(albumId);
    }

    /**
     * In this case, if we delete an album, the corresponding photos and comments will be deleted.
     */

    @DeleteMapping("/dPhotosComments/{albumId}")
    public void deleteAlbumWithPhotosComments(@PathVariable("albumId") String albumId){
        albumService.deleteAlbumWithPhotosComments(albumId);
    }












}
