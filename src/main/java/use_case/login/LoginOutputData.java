package use_case.login;

/**
 * The output data for the login use case.
 */
public class LoginOutputData {
    private final boolean success;
    private final String message;
    private final String puuid;

    public LoginOutputData(boolean success, String message, String puuid) {
        this.success = success;
        this.message = message;
        this.puuid = puuid;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

    public String getPuuid() {
        return puuid;
    }
}

