package interface_adapter.login;

import use_case.login.LoginInputBoundary;
import use_case.login.LoginInputData;

/**
 * Controller for handling login requests.
 */
public class LoginController {
    private final LoginInputBoundary loginInputBoundary;

    public LoginController(LoginInputBoundary loginInputBoundary) {
        this.loginInputBoundary = loginInputBoundary;
    }

    public void execute(String username, String tagline, String region) {
        LoginInputData inputData = new LoginInputData(username, tagline, region);
        loginInputBoundary.login(inputData);
    }
}
