package use_case.login;

import data_access.RiotUserDataAccessObject;
import entity.FunFacts.FunFacts;
import entity.OverviewProfile.ProfileOverview;
import entity.OverviewProfile.Rank;
import entity.champion.Champion;
import entity.freeChampionRotation.FreeChampionRotation;
import entity.matchHistory.MatchHistory;
import entity.user.User;

import java.util.List;

/**
 * The interactor for the login use case.
 */
public class LoginInteractor implements LoginInputBoundary {

    private final RiotUserDataAccessObject userDataAccessObject;
    private final LoginOutputBoundary loginPresenter;

    public LoginInteractor(RiotUserDataAccessObject userDataAccessObject, LoginOutputBoundary loginPresenter) {
        this.userDataAccessObject = userDataAccessObject;
        this.loginPresenter = loginPresenter;
    }

    @Override
    public void execute(LoginInputData inputData) {
        try {
            final User user = userDataAccessObject.getUser(inputData.getUsername(),
                    inputData.getTagline(), inputData.getRegion());
            final ProfileOverview profileOverview = userDataAccessObject.getProfileOverview(user.getPuuid(), user.getRegion());
            final Rank rank = userDataAccessObject.getRank(profileOverview.getSummonerId(), user.getRegion());
            final MatchHistory matchHistory = userDataAccessObject.getMatchHistory(user.getPuuid(), user.getRegion(), 20);
            final FreeChampionRotation freeChampionRotation = userDataAccessObject.getFreeChampionRotation();
            final FunFacts funFacts = userDataAccessObject.getFunFacts(user.getPuuid(), user.getRegion());
            final List<Champion> champion = userDataAccessObject.getChampions(user.getPuuid(), user.getRegion());
            loginPresenter.prepareSuccessView(new LoginOutputData(user, profileOverview, rank, matchHistory, freeChampionRotation, funFacts));
        }
        catch (Exception e) {
            loginPresenter.prepareFailView(new LoginOutputData(null, null, null, null, null, null));
        }
    }
}
