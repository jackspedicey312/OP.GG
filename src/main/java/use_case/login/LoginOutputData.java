package use_case.login;

public class LoginOutputData {
    private final boolean success;
    private final String puuid;
    private final String message;

    public LoginOutputData(boolean success, String puuid, String message) {
        this.success = success;
        this.puuid = puuid;
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getPuuid() {
        return puuid;
    }

    public String getMessage() {
        return message;
    }
}

