package use_case.login;

import data_access.RiotUserDataAccessObject;

/**
 * The interactor for the login use case.
 */
public class LoginInteractor implements LoginInputBoundary {

    private final RiotUserDataAccessObject userDataAccessObject;
    private final LoginOutputBoundary presenter;

    public LoginInteractor(RiotUserDataAccessObject userDataAccessObject, LoginOutputBoundary presenter) {
        this.userDataAccessObject = userDataAccessObject;
        this.presenter = presenter;
    }

    @Override
    public void execute(LoginInputData inputData) {
        try {
            String username = inputData.getUsername();
            String tagline = inputData.getTagline();
            String region = inputData.getRegion();
            // Fetch PUUID using the data access layer
            final String puuid = userDataAccessObject.fetchPUUID(username, tagline, region);
            userDataAccessObject.createUser(username, tagline, region);
            // Pass successful login data to the presenter
            presenter.prepareSuccessView(new LoginOutputData(true, "Login successful!", puuid));
        } catch (Exception e) {
            // Pass error data to the presenter
            presenter.prepareFailView(new LoginOutputData(false, "Login failed: " + e.getMessage(), null));
        }
    }
}
