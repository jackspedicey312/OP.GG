package entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a user in the system.
 */
public class User {
    private final String username;
    private final String tagline;
    private final String region;
    private final String puuid; // Unique identifier from Riot API
    private final MatchList matchList;

    public User(String username, String tagline, String region, String puuid, MatchList matchList) {
        this.username = username;
        this.tagline = tagline;
        this.region = region;
        this.puuid = puuid;
        this.matchList = matchList;
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

    public MatchList getMatchList() {
        return matchList;
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
