package com.fokhrul.mobileappws.ui.controller;

import com.fokhrul.mobileappws.ui.model.request.UpdateUserDetailsRequestModel;
import com.fokhrul.mobileappws.ui.model.request.UserDetailsRequestModel;
import com.fokhrul.mobileappws.ui.model.response.UserRest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping(value = "/users")   //localhost:8080/users/
public class UserController {
    /**
     * Create a Map to temporarily store information.
     */
    Map<String, UserRest> users;

    /**
     * defaultValue helps make a parameter optional.
     * required=false   can also be used. But it should not be used with primitive data
     * @param page
     * @param limit
     * @return
     */
    @GetMapping
    public String getUser(@RequestParam (value="page", defaultValue = "1") int page,
                          @RequestParam(value = "limit") int limit,
                          @RequestParam(value = "sort",defaultValue = "descending", required = false) String sort)
    {
        return "get user was called with page="+page+" and limit="+limit;
    }

    /**
     * "produces" returns the object in a specific format.
     * Here we want the response in either xml or json format. For this,
     * we need to add related dependencies to the pom.xml file
     * Suppose, we want to return the Http status code also. Then
     * we need to use ResponseEntity. It has multiple constructors.
     * @param userId
     * @return   an object of type UserRest
     */
    @GetMapping(value = "/get", path = "/{userId}",
            produces = {
                    MediaType.APPLICATION_XML_VALUE,
                    MediaType.APPLICATION_JSON_VALUE
            })
    public ResponseEntity<UserRest> getUser(@PathVariable String userId){
//        UserRest userRest = new UserRest();
//        userRest.setUserId(userId);
//        userRest.setFirstName("Fokhrul");
//        userRest.setLastName("Alam");
//        userRest.setEmail("fn208dlsnh@hotmail.com");
        String firstName = null;

        int firstNameLength = firstName.length();
        if (users.containsKey(userId)){
            return new ResponseEntity<UserRest>(users.get(userId), HttpStatus.OK);
        }else{
            return new ResponseEntity<UserRest>(HttpStatus.NO_CONTENT);
        }


    }

    /**
     * To accept a whole body passed by the user, @RequestBody is used.
     * Here we want data from user in either json or xml format.
     * "consumes" is used for this purpose.
     * If we want to pass HttpStatus code, an object of ResponseEntity class should be used
     * @return
     */
    @PostMapping(value = "/post", consumes = {
            MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE
            }, produces = {
                MediaType.APPLICATION_XML_VALUE,
                MediaType.APPLICATION_JSON_VALUE
                })
    public ResponseEntity<UserRest> createUser(@Valid @RequestBody UserDetailsRequestModel userDetails){
        UserRest returnValue = new UserRest();

        returnValue.setFirstName(userDetails.getFirstName());
        returnValue.setLastName(userDetails.getLastName());
        returnValue.setEmail(userDetails.getEmail());


        /**
         * If there are no users, create a HashMap object and assign it to users.
         * We will use a random number as the key.
         */
        String userId = UUID.randomUUID().toString();
        returnValue.setUserId(userId);

        if (users == null) users = new HashMap<>();
        users.put(userId, returnValue);

        return new ResponseEntity<UserRest>(returnValue, HttpStatus.OK);

    }

    @PutMapping(value = "/update", path = "/{userId}", consumes = {
            MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE
            }, produces = {
                MediaType.APPLICATION_XML_VALUE,
                MediaType.APPLICATION_JSON_VALUE
                })
    public UserRest updateUser(@PathVariable String userId,
                             @Valid @RequestBody UpdateUserDetailsRequestModel userDetails){
        UserRest storedUserDetails  = users.get(userId);
        storedUserDetails.setFirstName(userDetails.getFirstName());
        storedUserDetails.setLastName(userDetails.getLastName());

        users.put(userId, storedUserDetails);
        return storedUserDetails;
    }

    @DeleteMapping(value = "/delete", path = "/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable String userId){
        users.remove(userId);
        return ResponseEntity.noContent().build();
    }




}

