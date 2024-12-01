package interface_adapter.matchHistory;

import entity.matchHistory.MatchHistory;

import javax.swing.ImageIcon;

public class MatchHistoryState {
    private MatchHistory matchHistory;

    public ImageIcon getChampionIcon(int index) {
        return matchHistory.getMatch(index).getChampionIcon();
    }

    public int getKills(int index) {
        return matchHistory.getMatch(index).getKills();
    }

    public int getDeaths(int index) {
        return matchHistory.getMatch(index).getDeaths();
    }

    public int getAssissts(int index) {
        return matchHistory.getMatch(index).getAssissts();
    }

    public String getDuration(int index) {
        return matchHistory.getMatch(index).getDuration();
    }

    public String getGameMode(int index) {
        return matchHistory.getMatch(index).getGameMode();
    }

    public String getDate(int index) {
        return matchHistory.getMatch(index).getDate();
    }

    public int getLength() {
        return matchHistory.getLength();
    }

    public MatchHistory getMatchHistory() {
        return matchHistory;
    }

    public void setMatchHistory(MatchHistory matchHistory) {
        this.matchHistory = matchHistory;
    }
}
