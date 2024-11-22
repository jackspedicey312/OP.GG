package interface_adapter.login;

import use_case.login.LoginOutputBoundary;
import use_case.login.LoginOutputData;

public class LoginPresenter implements LoginOutputBoundary {

    private String puuid; // Stores the PUUID for later use
    private String message; // Stores the success or failure message

    @Override
    public void present(LoginOutputData outputData) {
        if (outputData.isSuccess()) {
            System.out.println(outputData.getMessage());
            System.out.println("Generated PUUID: " + outputData.getPuuid());
            this.puuid = outputData.getPuuid();
        } else {
            System.err.println(outputData.getMessage());
            this.puuid = null;
        }
        this.message = outputData.getMessage();
    }

    public String getPuuid() {
        return puuid;
    }

    public String getMessage() {
        return message;
    }
}
