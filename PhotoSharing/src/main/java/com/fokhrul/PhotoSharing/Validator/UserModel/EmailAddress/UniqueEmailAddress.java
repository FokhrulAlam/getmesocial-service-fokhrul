package com.fokhrul.PhotoSharing.Validator.UserModel.EmailAddress;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = UniqueEmailAddressValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface UniqueEmailAddress {

    String message() default "Email address is already used.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
