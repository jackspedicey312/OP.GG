package view;

public class LoggedInState {
    private String username = "";
    private String tagline = "";
    private String puuid = "";

    public String getUsername() {
        return username;
    }

    public String getTagline() {
        return tagline;
    }

    public String getPuuid() {
        return puuid;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setTagline(String tagline) {
        this.tagline = tagline;
    }

    public void setPuuid(String puuid) {
        this.puuid = puuid;
    }
}
