package com.fokhrul.PhotoSharing.Validator.UserModel.ProfilePhotoUrl;


import com.fokhrul.PhotoSharing.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueProfilePhotoUrlValidator implements ConstraintValidator<UniqueProfilePhotoUrl, String> {

    @Autowired
    private UserService userService;

    /**
     * When this validation will not be satisfied, the default message of the annotation will show up.
     * @param uniqueProfilePhotoUrl is the object of our annotation
     */
    @Override
    public void initialize(UniqueProfilePhotoUrl uniqueProfilePhotoUrl) {
        uniqueProfilePhotoUrl.message();
    }

    /**
     * In this method, we will check whether the validation is satisfied or not.
     * For our case, if this method returns "true", validation is satisfied and the new profilePhotoUrl
     * can be inserted into the collection. But, if this method returns "false", the default message will
     * show up and this profilePhotoUrl can not be inserted.
     * @param profilePhotoUrl is the URL of the profile photo.
     * @param constraintValidatorContext is the reference of ConstraintValidatorContext.
     * @return either or false.
     */
    @Override
    public boolean isValid(String profilePhotoUrl, ConstraintValidatorContext constraintValidatorContext) {
        /**
         * We will check whether the profilePhotoUrl exists in the collection or not. If the profilePhotoUrl
         * exists in the collection, we will return false, that means our profilePhotoUrl is not valid.
         * Otherwise, we will return true, that means our profilePhotoUrl is valid and can be inserted into
         * the corresponding collection.
         * checkExistenceOfProfilePhotoUrl() method of UserService class returns "true" if the profilePhotoUrl
         * is already in the collection. Then isValid() method is returning "false".
         * checkExistenceOfProfilePhotoUrl() method of UserService class returns "false" if the profilePhotoUrl
         * does not exist in the collection. Then isValid() method is returning "true".
         */
        return !userService.checkExistenceOfProfilePhotoUrl(profilePhotoUrl);
    }
}
