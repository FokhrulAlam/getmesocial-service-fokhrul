package com.fokhrul.PhotoSharing.Validator.UserModel.EmailAddress;

import com.fokhrul.PhotoSharing.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueEmailAddressValidator implements ConstraintValidator<UniqueEmailAddress, String> {

    @Autowired
    private UserService userService;

    @Override
    public void initialize(UniqueEmailAddress constraintAnnotation) {
        constraintAnnotation.message();
    }

    @Override
    public boolean isValid(String userEmail, ConstraintValidatorContext constraintValidatorContext) {
        return !userService.checkExistenceOfEmailAddress(userEmail);
    }
}
