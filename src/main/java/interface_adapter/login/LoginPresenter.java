package interface_adapter.login;

import use_case.login.LoginOutputBoundary;
import use_case.login.LoginOutputData;

/**
 * Presenter for handling login output.
 */
public class LoginPresenter implements LoginOutputBoundary {

    private String puuid;
    private String message;

    @Override
    public void present(LoginOutputData outputData) {
        this.puuid = outputData.getPuuid();
        this.message = outputData.getMessage();
    }

    public String getPuuid() {
        return puuid;
    }

    public String getMessage() {
        return message;
    }
}
