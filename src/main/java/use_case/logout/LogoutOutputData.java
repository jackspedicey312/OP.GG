package use_case.logout;

/**
 * Output Data for the Logout Use Case.
 */
public class LogoutOutputData {

    private final String username;
    private final String tagline;
    private final boolean useCaseFailed;

    public LogoutOutputData(String username, String tagline, boolean useCaseFailed) {
        this.username = username;
        this.tagline = tagline;
        this.useCaseFailed = useCaseFailed;
    }

    public String getUsername() {
        return username;
    }

    public String getTagline() {
        return tagline;
    }

    public boolean isUseCaseFailed() {
        return useCaseFailed;
    }
}