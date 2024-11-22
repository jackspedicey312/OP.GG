package use_case.login;

public class LoginInputData {
    private final String username;
    private final String tagline;
    private final String region;

    public LoginInputData(String username, String tagline, String region) {
        this.username = username;
        this.tagline = tagline;
        this.region = region;
    }

    public String getUsername() {
        return username;
    }

    public String getTagline() {
        return tagline;
    }

    public String getRegion() {
        return region;
    }
}

