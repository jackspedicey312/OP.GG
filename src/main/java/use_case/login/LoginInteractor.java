package use_case.login;

import data_access.RiotAPIUserDataAccess;

/**
 * The interactor for the login use case.
 */
public class LoginInteractor implements LoginInputBoundary {

    private final RiotAPIUserDataAccess dataAccess;
    private final LoginOutputBoundary presenter;

    public LoginInteractor(RiotAPIUserDataAccess dataAccess, LoginOutputBoundary presenter) {
        this.dataAccess = dataAccess;
        this.presenter = presenter;
    }

    @Override
    public void login(LoginInputData inputData) {
        try {
            // Fetch PUUID using the data access layer
            String puuid = dataAccess.fetchPUUID(inputData.getUsername(), inputData.getTagline(), inputData.getRegion());
            // Pass successful login data to the presenter
            presenter.present(new LoginOutputData(true, "Login successful!", puuid));
        } catch (Exception e) {
            // Pass error data to the presenter
            presenter.present(new LoginOutputData(false, "Login failed: " + e.getMessage(), null));
        }
    }
}
