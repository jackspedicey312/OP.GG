package app;

import use_case.login.LoginOutputBoundary;
import use_case.login.LoginOutputData;

public class CLIOutputPresenter implements LoginOutputBoundary {
    private String puuid;

    @Override
    public void present(LoginOutputData outputData) {
        if (outputData.isSuccess()) {
            System.out.println(outputData.getMessage());
            System.out.println("Generated PUUID: " + outputData.getPuuid());
            this.puuid = outputData.getPuuid();
        } else {
            System.err.println(outputData.getMessage());
        }
    }

    public String getPuuid() {
        return puuid;
    }
}
