package com.fokhrul.PhotoSharing.Validator.UserModel.ProfilePhotoUrl;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * @Documented creates the documentation for this annotation.
 * @Constraint specifies our custom class that will handle this annotation.
 * @Target specifies where we can use our custom validation. In this case, we will use it for fields.
 * @Retention specifies exactly when this annotation will work.
 */

@Documented
@Constraint(validatedBy = UniqueProfilePhotoUrlValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface UniqueProfilePhotoUrl {

    /**
     *The following is the default message to be shown if the user does
     * not specify any default message for this annotation.
     */
    String message() default "Profile photo URL should be unique.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
