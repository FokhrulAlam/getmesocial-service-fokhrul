package com.fokhrul.PhotoSharing.resource;

import com.fokhrul.PhotoSharing.model.Comment;
import com.fokhrul.PhotoSharing.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/comments")
public class CommentResource {
    @Autowired
    private CommentService commentService;

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

    @PostMapping
    public void saveComment(@RequestBody Comment comment){
        commentService.saveComment(comment);
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
