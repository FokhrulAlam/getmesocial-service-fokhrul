package com.fokhrul.PhotoSharing.model;

import com.fokhrul.PhotoSharing.Validator.AlbumModel.CoverPhotoUrl.UniqueCoverPhotoUrl;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "albums")

public class Album {
    @Id
    private String id;    //id of the album

    @NotBlank(message = "Album name can not be blank.")
    @Size(min = 4, max = 10, message = "Album name should contains minimum 4 characters and maximum 10 characters.")
    private String name;    //name of the album

    @UniqueCoverPhotoUrl
    private String coverPhotoUrl;   //url of the cover photo of the album

    private String createdBy;       //user who created the album

    @DateTimeFormat
    private Date dateCreated;     //date the album was created on
}
