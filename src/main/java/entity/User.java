package entity;

public class User {
    private String username;
    private String tagline;
    private String region;
    private String puuid;

    public User(String username, String tagline, String region) {
        this.username = username;
        this.tagline = tagline;
        this.region = region;
    }

    // Getters and Setters
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

    public void setPuuid(String puuid) {
        this.puuid = puuid;
    }
}
