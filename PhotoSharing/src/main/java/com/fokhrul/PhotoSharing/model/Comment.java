package com.fokhrul.PhotoSharing.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "comments")
public class Comment {
    @Id
    private String id;        //id of the comment

    private String photoId;      //id of the corresponding photo

    @NotBlank
    @Size(min = 1, max = 20, message = "Comments should contain minimum 1 character and maximum 20 characters.")
    private String message;     //message passed by the user

    private String createdBy;       //user who made the comments

    @DateTimeFormat
    private Date dateCreated;     //date the comments were made on
}
