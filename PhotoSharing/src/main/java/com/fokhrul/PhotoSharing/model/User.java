package com.fokhrul.PhotoSharing.model;


import com.fokhrul.PhotoSharing.Validator.UserModel.EmailAddress.UniqueEmailAddress;
import com.fokhrul.PhotoSharing.Validator.UserModel.ProfilePhotoUrl.UniqueProfilePhotoUrl;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.URL;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


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

    @NotBlank(message = "User name can not be null and the size should be greater than zero.")
    @Size(min = 8, max = 15, message = "The length of user name should be minimum 8 and maximum 15.")
    private String name;    //name of the user


    @NotBlank(message = "Email can not be null and the trimmed length should be greater than zero.")
    @Email(message = "Email should be in a valid format.")
    @UniqueEmailAddress
    private String email;   //email of the user

    @URL(message = "URL should be in a valid format")
    @UniqueProfilePhotoUrl
    private String profilePhotoUrl;     //url of the profile photo
}
