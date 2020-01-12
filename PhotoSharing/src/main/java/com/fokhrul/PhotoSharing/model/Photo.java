package com.fokhrul.PhotoSharing.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "photos")
@Component
public class Photo {
    @Id
    private String photoId;    //id of the photo

    private String albumId;      //id of the corresponding album

    private String photoUrl;    //url of the photo

    private String createdBy;       //name of the user who created this photo

    @DateTimeFormat
    private Date dateCreated;     //date the photo was created
}
