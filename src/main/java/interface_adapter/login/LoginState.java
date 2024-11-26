package interface_adapter.login;

/**
 * The state for the Login View Model.
 */
public class LoginState {
    private String loginError;

    public String getLoginError() {
        return loginError;
    }

    public void setLoginError(String loginError) {
        this.loginError = loginError;
    }

}
