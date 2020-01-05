package com.fokhrul.PersonInfo.resource;

import com.fokhrul.PersonInfo.model.Profile;
import com.fokhrul.PersonInfo.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/profiles")
public class ProfileResource {
    @Autowired
    private ProfileService profileService;

    @GetMapping(value = "/fetch")
    public Profile getProfile(){
        return profileService.getProfile();
    }
}
