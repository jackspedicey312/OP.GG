package use_case.login;

import entity.freeChampionRotation.FreeChampionRotation;
import entity.user.User;

/**
 * The output data for the login use case.
 */
public class LoginOutputData {
    private final User user;
//    private final MatchList matchList;
    private final FreeChampionRotation freeChampionRotation;

    public LoginOutputData(User user, /*MatchList matchList,*/
                           FreeChampionRotation freeChampionRotation) {
        this.user = user;
//        this.matchList = matchList;
        this.freeChampionRotation = freeChampionRotation;
    }

    public User getUser() {
        return user;
    }

//    public MatchList getMatchList() {
//        return matchList;
//    }

    public FreeChampionRotation getFreeChampionRotation() {
        return freeChampionRotation;
    }
}
