package interface_adapter.profile;

import entity.OverviewProfile.ProfileOverview;
import entity.OverviewProfile.Rank;

import javax.swing.*;

public class ProfileState {
    private ProfileOverview profileOverview;
    private Rank rank;

    public void setProfileOverview(ProfileOverview profileOverview) {
        this.profileOverview = profileOverview;
    }

    public void setRank(Rank rank) {
        this.rank = rank;
    }

    public String getUsername() {
        return profileOverview.getUsername();
    }

    public String getTagline() {
        return profileOverview.getTagline();
    }

    public int getProfileLevel() {
        return profileOverview.getSummonerLevel();
    }

    public ImageIcon getProfileIcon() {
        return profileOverview.getSummonerImage();
    }

    public String getGameMode() {
        return rank.getGameMode();
    }

    public String getDivision() {
        return rank.getDivision();
    }

    public int getLeaguePoints() {
        return rank.getLeaguePoints();
    }

    public int getWins() {
        return rank.getWins();
    }

    public int getLosses() {
        return rank.getLosses();
    }

    public int getWinRate() {
        return rank.getWinRate();
    }

    public ImageIcon getRankIcon() {
        return rank.getRankIcon();
    }

    public ProfileOverview getProfileOverview() {
        return profileOverview;
    }

    public Rank getRank() {
        return rank;
    }
}
