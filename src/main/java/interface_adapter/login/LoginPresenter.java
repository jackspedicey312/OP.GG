package interface_adapter.login;

import use_case.login.LoginOutputBoundary;
import use_case.login.LoginOutputData;

/**
 * Presenter for formatting the output of login use case.
 */
public class LoginPresenter implements LoginOutputBoundary {
    private String puuid;
    private String message;

    @Override
    public void present(LoginOutputData outputData) {
        this.puuid = outputData.getPuuid();
        this.message = outputData.getMessage();

        if (outputData.isSuccess()) {
            System.out.println("Login Successful! PUUID: " + puuid);
        } else {
            System.err.println("Login Failed: " + message);
        }
    }

    public String getPuuid() {
        return puuid;
    }

    public String getMessage() {
        return message;
    }
}

