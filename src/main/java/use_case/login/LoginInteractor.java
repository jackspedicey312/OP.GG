package use_case.login;

import data_access.RiotUserDataAccessObject;
import entity.FreeChampionRotation.FreeChampionRotation;
import entity.MatchList.MatchList;
import entity.User.User;

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
            final MatchList matchList = userDataAccessObject.getMatchList(user.getPuuid(), user.getRegion(), 20);
            final FreeChampionRotation freeChampionRotation = userDataAccessObject.getFreeChampionRotation();
            loginPresenter.prepareSuccessView(new LoginOutputData(user, matchList, freeChampionRotation));
        } catch (Exception e) {
            loginPresenter.prepareFailView(new LoginOutputData(null, null, null));
        }
    }
}
