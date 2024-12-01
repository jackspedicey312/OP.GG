package use_case.login;

import entity.OverviewProfile.ProfileOverview;
import entity.OverviewProfile.Rank;
import entity.freeChampionRotation.FreeChampionRotation;
import entity.matchHistory.MatchHistory;
import entity.user.User;

/**
 * The output data for the login use case.
 */
public class LoginOutputData {
    private final User user;
    private final ProfileOverview profileOverview;
    private final Rank rank;
    private final MatchHistory matchHistory;
    private final FreeChampionRotation freeChampionRotation;

    public LoginOutputData(User user,
                           ProfileOverview profileOverview,
                           Rank rank,
                           MatchHistory matchList,
                           FreeChampionRotation freeChampionRotation) {
        this.user = user;
        this.profileOverview = profileOverview;
        this.rank = rank;
        this.matchHistory = matchList;
        this.freeChampionRotation = freeChampionRotation;
    }

    public User getUser() {
        return user;
    }

    public ProfileOverview getProfileOverview() {
        return profileOverview;
    }

    public Rank getRank() {
        return rank;
    }

    public MatchHistory getMatchHistory() {
        return matchHistory;
    }

    public FreeChampionRotation getFreeChampionRotation() {
        return freeChampionRotation;
    }
}
