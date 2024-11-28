package entity;

import data_access.RiotUserDataAccessObject;

public class UserFactory {

    public User createUser(String username, String tagline, String region, String puuId) throws Exception {
        return new User(username, tagline, region, puuId);
    }
}
