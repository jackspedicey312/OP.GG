package data_access;

import entity.User;
import entity.UserFactory;
//import use_case.freechampionrotation.FreeChampionRotationUserDataAccessInterface;
import use_case.login.LoginUserDataAccessInterface;

public class RiotUserDataAccessObject implements LoginUserDataAccessInterface {
//        FreeChampionRotationUserDataAccessInterface {
    private User user;

    private final RiotAPIUserDataAccess userDataAccess = new RiotAPIUserDataAccess();
    private final UserFactory userFactory = new UserFactory();

    public String fetchPuuId(String username, String tagline, String region) throws Exception {
        return userDataAccess.fetchPuuId(username, tagline, region);
    }

}
