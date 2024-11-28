package view;

import entity.*;

public class LoggedInState {
    private User user;
    private MatchList matchList;
    private PlayerStats playerStats;
    private FreeChampionRotation freeChampionRotation;

    private final UserFactory userFactory = new UserFactory();
    private final FreeChampionRotationFactory freeChampionRotationFactory = new FreeChampionRotationFactory();

    public String getUser() {
        return username;
    }

    public void setUsername(String username) {
        this.user = userFactory.createUser()
    }

}
