package com.fokhrul.PhotoSharing.Validator.AlbumModel.CoverPhotoUrl;



import com.fokhrul.PhotoSharing.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueCoverPhotoUrlValidator implements ConstraintValidator<UniqueCoverPhotoUrl, String> {

    @Autowired
    private AlbumService albumService;

    @Override
    public void initialize(UniqueCoverPhotoUrl constraintAnnotation) {
        constraintAnnotation.message();
    }

    @Override
    public boolean isValid(String coverPhotoUrl, ConstraintValidatorContext constraintValidatorContext) {
        return !albumService.checkExistenceOfCoverPhotoUrl(coverPhotoUrl);
    }
}
