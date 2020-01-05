package com.fokhrul.PersonInfo.service;

import com.fokhrul.PersonInfo.model.Profile;
import com.fokhrul.PersonInfo.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfileService {
    @Autowired
    private ProfileRepository profileRepository;

    public Profile getProfile(){
        return profileRepository.getProfile();
    }
}
