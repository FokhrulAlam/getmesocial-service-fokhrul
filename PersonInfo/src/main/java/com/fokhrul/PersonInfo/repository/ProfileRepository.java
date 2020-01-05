package com.fokhrul.PersonInfo.repository;

import com.fokhrul.PersonInfo.model.Address;
import com.fokhrul.PersonInfo.model.Profile;
import org.springframework.stereotype.Repository;

@Repository
public class ProfileRepository {

    public Profile getProfile(){

        Profile profile = new Profile("Salman Shah", 53,
                new Address("Sylhet","Bangladesh"), "7362584");

        return profile;
    }
}
