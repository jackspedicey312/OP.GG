package interface_adapter.matchHistory;

import entity.match.Match;
import use_case.matchHistory.MatchHistoryInputBoundary;

public class MatchHistoryController {

    private final MatchHistoryInputBoundary matchHistoryInputBoundary;

    public MatchHistoryController(MatchHistoryInputBoundary matchHistoryInputBoundary) {
        this.matchHistoryInputBoundary = matchHistoryInputBoundary;
    }

    public void execute() {
        matchHistoryInputBoundary.execute();
    }
}
