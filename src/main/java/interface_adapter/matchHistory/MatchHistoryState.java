package interface_adapter.matchHistory;

import entity.matchHistory.MatchHistory;

public class MatchHistoryState {
    private MatchHistory matchHistory;

    public MatchHistory getMatchHistory() {
        return matchHistory;
    }

    public void setMatchHistory(MatchHistory matchHistory) {
        this.matchHistory = matchHistory;
    }
}
