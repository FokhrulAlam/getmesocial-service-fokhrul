package com.fokhrul.PhotoSharing.service;

import com.fokhrul.PhotoSharing.model.Comment;
import com.fokhrul.PhotoSharing.model.Photo;
import com.fokhrul.PhotoSharing.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;

    /**
     * Get a single comment found by id
     * @param commentId
     * @return
     */
    public Optional<Comment> getSingleComment(String commentId) {
        return commentRepository.findById(commentId);
    }

    /**
     * Gell all comments
     * @return
     */
    public List<Comment> getComment() {
        return commentRepository.findAll();
    }

    public void saveComment(Comment comment) {
        commentRepository.save(comment);
    }

    public void editComment(Comment comment) {
        commentRepository.save(comment);
    }

    public void deleteComment(String id) {
        commentRepository.deleteById(id);
    }

    /**
     * delete all comments
     */
    public void deleteAllComments() {
        commentRepository.deleteAll();
    }

    /**
     * Delete comments by photoId
     * @param photoId
     */
    public void deleteCommentByPhotoId(String photoId){
        commentRepository.deleteByPhotoId(photoId);
    }

}
