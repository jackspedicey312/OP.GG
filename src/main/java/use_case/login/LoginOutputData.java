package use_case.login;

import entity.freeChampionRotation.FreeChampionRotation;
import entity.matchHistory.MatchHistory;
import entity.user.User;

/**
 * The output data for the login use case.
 */
public class LoginOutputData {
    private final User user;
    private final MatchHistory matchHistory;
    private final FreeChampionRotation freeChampionRotation;

    public LoginOutputData(User user, MatchHistory matchList,
                           FreeChampionRotation freeChampionRotation) {
        this.user = user;
        this.matchHistory = matchList;
        this.freeChampionRotation = freeChampionRotation;
    }

    public User getUser() {
        return user;
    }

    public MatchHistory getMatchHistory() {
        return matchHistory;
    }

    public FreeChampionRotation getFreeChampionRotation() {
        return freeChampionRotation;
    }
}
