package New;

import org.json.JSONArray;

public class User {
    private final String username;
    private final String tagline;
    private final String region;
    private final String puuid;
    private final JSONArray matchList;

    public User(String username, String tagline, String region, String puuid, JSONArray matchList) {
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

    public JSONArray getMatchList() {
        return matchList;
    }
}
