package interface_adapter.login;

public class LoginState {
    private String username;
    private String tagline;
    private String loginError;

    public String getUsername() {
        return username;
    }

    public String getTagline() {
        return tagline;
    }

    public String getLoginError() {
        return loginError;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setTagline(String tagline) {
        this.tagline = tagline;
    }

    public void setLoginError(String loginError) {
        this.loginError = loginError;
    }
}
