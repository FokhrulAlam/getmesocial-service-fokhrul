package com.fokhrul.PhotoSharing.resource;

import com.fokhrul.PhotoSharing.exception.customeExceptionHandler.InvalidPhotoIdException;
import com.fokhrul.PhotoSharing.model.Comment;
import com.fokhrul.PhotoSharing.service.CommentService;
import com.fokhrul.PhotoSharing.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/comments")
public class CommentResource {
    @Autowired
    private CommentService commentService;

    @Autowired
    private PhotoService photoService;

    /**
     * Get a single comment found by id
     * @return
     */
    @GetMapping(path = "/{commentId}")
    public Optional<Comment> getSingleComment(@PathVariable("commentId") String commentId){
        return commentService.getSingleComment(commentId);
    }

    /**
     * Get all comments.
     * @return
     */
    @GetMapping
    public List<Comment> getComment(){
        return commentService.getComment();
    }

    /**
     * Save a single comments
     * @param comment
     */
    @PostMapping("/saveSingleComment")
    public void saveComment(@RequestBody Comment comment){
        if (photoService.checkExistenceByPhotoId(comment.getPhotoId())) {
            commentService.saveComment(comment);
        }else{
            throw new InvalidPhotoIdException();
        }
    }

    @PutMapping(path = "/{id}")
    public void editComment(@PathVariable("id") String id, @RequestBody Comment comment){
        comment.setId(id);
        commentService.editComment(comment);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteComment(@PathVariable("id") String id){
        commentService.deleteComment(id);
    }

    /**
     * Delete all comments
     */
    @DeleteMapping("/deleteAll")
    public void deleteAllComments(){
        commentService.deleteAllComments();
    }
}
