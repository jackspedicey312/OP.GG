package use_case.login;

import data_access.RiotAPILoginDataAccess;
import entity.User;

public class LoginInteractor implements LoginInputBoundary {
    private final RiotAPILoginDataAccess dataAccess;
    private final LoginOutputBoundary outputBoundary;

    public LoginInteractor(RiotAPILoginDataAccess dataAccess, LoginOutputBoundary outputBoundary) {
        this.dataAccess = dataAccess;
        this.outputBoundary = outputBoundary;
    }

    @Override
    public void login(LoginInputData inputData) {
        try {
            // Create a User instance
            User user = new User(inputData.getUsername(), inputData.getTagline(), inputData.getRegion());

            // Fetch PUUID
            String puuid = dataAccess.fetchPUUID(user);

            // Create success output data
            LoginOutputData outputData = new LoginOutputData(true, puuid, "Login successful!");
            outputBoundary.present(outputData);
        } catch (Exception e) {
            // Create failure output data
            LoginOutputData outputData = new LoginOutputData(false, null, "Login failed: " + e.getMessage());
            outputBoundary.present(outputData);
        }
    }
}
