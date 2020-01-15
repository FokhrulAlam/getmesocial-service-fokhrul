package com.fokhrul.PhotoSharing.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.URL;
import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.*;

/**
 * We used lombok dependency in this project. We will utilize its useful  features.
 * @Data annotation creates getter and setter methods of the fields.
 * @NoArgsConstructor creates a default constructor.
 * @AllArgsConstructor creates a parameterized constructor.
 * @Document    adds the objects to a collection in MongoDb database server.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "users")
public class User {
    /**
     * To assign an auto-generated id to field id, @Id annotation is used.
     */
    @Id
    private String id;      //id of the user

    @NotNull(message = "User name should not be null.")
    @Size(min = 8, max = 15, message = "User name should contain minimum 8 and maximum 15 characters")
    private String name;    //name of the user

    @NotNull
    @Email(message = "Email should be in a valid format.")
//    @UniqueElements(message = "The email address is already used. Please use a different email address.")
    private String email;   //email of the user

    @URL(message = "URL should be in a valid format")
    private String profilePhotoUrl;     //url of the profile photo
}
