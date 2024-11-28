package use_case.login;

import data_access.RiotUserDataAccessObject;
import entity.MatchList;
import entity.User;

/**
 * The interactor for the login use case.
 */
public class LoginInteractor implements LoginInputBoundary {

    private final RiotUserDataAccessObject userDataAccessObject;
    private final LoginOutputBoundary loginPresenter;

    public LoginInteractor(RiotUserDataAccessObject userDataAccessObject, LoginOutputBoundary presenter) {
        this.userDataAccessObject = userDataAccessObject;
        this.loginPresenter = presenter;
    }

    @Override
    public void execute(LoginInputData inputData) {
        try {
            // Fetch PUUID using the data access layer
            final User user = userDataAccessObject.getUser(inputData.getUsername(),
                    inputData.getTagline(), inputData.getRegion());
            final MatchList matchList = userDataAccessObject.getMatchList(user.getPuuid(), user.getRegion(), 20);
            // Pass successful login data to the presenter
            loginPresenter.prepareSuccessView(new LoginOutputData(true, "Login successful!",
                    inputData.getUsername(), inputData.getTagline(), inputData.getRegion(), puuid));
        } catch (Exception e) {
            // Pass error data to the presenter
            loginPresenter.prepareFailView(new LoginOutputData(false, "Login failed: " + e.getMessage(),
                    null, null, null, null));
        }
    }
}
