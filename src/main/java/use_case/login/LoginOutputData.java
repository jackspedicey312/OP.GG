package use_case.login;

import entity.FreeChampionRotation;
import entity.MatchList;
import entity.User;

/**
 * The output data for the login use case.
 */
public class LoginOutputData {
    private final boolean success;
    private final String message;
    private final User user;
    private final MatchList matchList;
    private final FreeChampionRotation freeChampionRotation;

    public LoginOutputData(boolean success, String message, User user, MatchList matchList, FreeChampionRotation freeChampionRotation) {
        this.success = success;
        this.message = message;
        this.user = user;
        this.matchList = matchList;
        this.freeChampionRotation = freeChampionRotation;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

    public User getUser() {
        return user;
    }

    public MatchList getMatchList() {
        return matchList;
    }

    public FreeChampionRotation getFreeChampionRotation() {
        return freeChampionRotation;
    }
}
