package com.fokhrul.PhotoSharing.Validator.AlbumModel.CoverPhotoUrl;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = UniqueCoverPhotoUrlValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface UniqueCoverPhotoUrl {

    String message() default "Cover photo URL is already in use.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
