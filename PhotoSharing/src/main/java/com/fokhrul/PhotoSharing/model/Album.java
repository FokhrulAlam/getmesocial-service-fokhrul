package com.fokhrul.PhotoSharing.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "albums")

public class Album {
    @Id
    private String id;    //id of the album

    private String name;    //name of the album

    private String coverPhotoUrl;   //url of the cover photo of the album

    private String createdBy;       //user who created the album

    @DateTimeFormat
    private Date dateCreated;     //date the album was created on
}
