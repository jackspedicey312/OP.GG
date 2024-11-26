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

    /**
     * Executes the login process.
     *
     * @param username The username provided by the user.
     * @param tagline The tagline provided by the user.
     * @param region The region selected by the user.
     */
    public void execute(String username, String tagline, String region) {
        final LoginInputData inputData = new LoginInputData(username, tagline, region);
        loginInputBoundary.execute(inputData);
    }
}
