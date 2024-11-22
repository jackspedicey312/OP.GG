package interface_adapter.login;

import use_case.login.LoginInputBoundary;
import use_case.login.LoginInputData;

public class LoginController {

    private final LoginInputBoundary loginInputBoundary;

    public LoginController(LoginInputBoundary loginInputBoundary) {
        this.loginInputBoundary = loginInputBoundary;
    }

    /**
     * Handles a login request by converting inputs and delegating to the use case.
     *
     * @param username The username provided by the user.
     * @param password The password provided by the user.
     */
    public void execute(String username, String password) {
        // Transform input and call the use case
        LoginInputData inputData = new LoginInputData(username, password, "NA"); // Default region example
        loginInputBoundary.login(inputData);
    }
}
