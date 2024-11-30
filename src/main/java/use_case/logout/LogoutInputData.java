package use_case.logout;

/**
 * The Input Data for the Logout Use Case.
 */
public class LogoutInputData {

    private final String username;
    private final String tagline;

    public LogoutInputData(String username, String tagline) {
        this.username = username;
        this.tagline = tagline;
    }

    public String getUsername() {
        return username;
    }
    public String getTagline() {
        return tagline;
    }
}