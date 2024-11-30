package entity.User;

/**
 * Represents a user in the system.
 */
public class User {
    private final String username;
    private final String tagline;
    private final String region;
    private final String puuid;

    public User(String username, String tagline, String region, String puuid) {
        this.username = username;
        this.tagline = tagline;
        this.region = region;
        this.puuid = puuid;

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

    public String getPuuid() {
        return puuid;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", tagline='" + tagline + '\'' +
                ", region='" + region + '\'' +
                ", puuid='" + puuid + '\'' +
                '}';
    }
}
