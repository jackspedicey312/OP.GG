package use_case.login;

import data_access.RiotUserDataAccessObject;
import entity.freeChampionRotation.FreeChampionRotation;
import entity.matchHistory.MatchHistory;
import entity.user.User;

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
            final MatchHistory matchHistory = userDataAccessObject.getMatchHistory(user.getPuuid(), user.getRegion(), 20);
            final FreeChampionRotation freeChampionRotation = userDataAccessObject.getFreeChampionRotation();
            loginPresenter.prepareSuccessView(new LoginOutputData(user, matchHistory, freeChampionRotation));
        } catch (Exception e) {
            loginPresenter.prepareFailView(new LoginOutputData(null, null, null));
        }
    }
}
