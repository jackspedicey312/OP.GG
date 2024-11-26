package data_access;

import entity.User;
import entity.UserFactory;
import use_case.freechampionrotation.FreeChampionRotationUserDataAccessInterface;

public class RiotUserDataAccessObject implements FreeChampionRotationUserDataAccessInterface {
    private User user;

    private final RiotAPIUserDataAccess userDataAccess = new RiotAPIUserDataAccess();
    private final UserFactory userFactory = new UserFactory();

    public createUser(String username, String tagline, String region) throws Exception {
        user = userFactory.createUser(username, tagline, userDataAccess.fetchPUUID(username, tagline, region),region)
    }
}
