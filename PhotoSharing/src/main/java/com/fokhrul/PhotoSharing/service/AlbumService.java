package com.fokhrul.PhotoSharing.service;

import com.fokhrul.PhotoSharing.model.Album;
import com.fokhrul.PhotoSharing.model.Comment;
import com.fokhrul.PhotoSharing.model.Photo;
import com.fokhrul.PhotoSharing.repository.AlbumRepository;
import com.fokhrul.PhotoSharing.repository.CommentRepository;
import com.fokhrul.PhotoSharing.repository.PhotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class AlbumService {

    @Autowired
    private AlbumRepository albumRepository;

    @Autowired
    private PhotoRepository photoRepository;

    @Autowired
    private CommentRepository commentRepository;


    /**
     * Get a single album.
     * @param albumId
     */
    public Optional<Album> getSingleAlbum(String albumId) {
       return albumRepository.findById(albumId);
    }

    /**
     * Gell all albums.
     * @return
     */
    public List<Album> getAlbums() {
        return albumRepository.findAll();
    }

    public void save(Album album) {

        albumRepository.save(album);
    }

    public void edit(Album album) {
        albumRepository.save(album);
    }

    /**
     * Delete a single album.
     * @param id
     */
    public void delete(String id) {
        albumRepository.deleteById(id);
    }

    /**
     * Delete all albums
     */
    public void deleteAllAlbums() {
        albumRepository.deleteAll();
    }

    /**
     * Now, if we delete an album, all photos of that album will be deleted too.
     * We will create a list and match the albumId.
     * If albumId matches, we will delete it.
     */

    public void deleteAlbumWithPhotos(String albumId) {

        List<Photo> photo = photoRepository.findAll();
        for (Photo obj : photo){
            if (obj.getAlbumId().equals(albumId)) {
                photoRepository.delete(obj);
            }
        }
        albumRepository.deleteById(albumId);
    }

    /**
     * We will delete corresponding photos and messages together with the album.
     * @param albumId
     */
    public void deleteAlbumWithPhotosComments(String albumId) {
        /**
         * Let's delete the comments first.
         */
        List<Comment> comments = commentRepository.findAll();

        List<Photo> photos = photoRepository.findAll();
        for (Photo photo : photos){
            if (photo.getAlbumId().equals(albumId)) {
                String idPhoto = photo.getPhotoId();    //storing the albumId of photo object
                photoRepository.delete(photo);      //deleting the photo of the current album
                /**
                 * let's delete the corresponding comments now.
                 */
                for (Comment comment : comments){
                    if (comment.getPhotoId().equals(idPhoto)){
                        commentRepository.delete(comment);
                    }
                }
            }
        }
        albumRepository.deleteById(albumId);
    }
}
