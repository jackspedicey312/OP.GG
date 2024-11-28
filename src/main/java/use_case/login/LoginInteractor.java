package use_case.login;

import data_access.RiotUserDataAccessObject;

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
            final String puuid = userDataAccessObject.fetchPuuId(inputData.getUsername(),
                    inputData.getTagline(), inputData.getRegion());
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
