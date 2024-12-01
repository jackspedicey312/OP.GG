package entity.matchHistory;

import entity.match.Match;

import java.util.List;

public class MatchHistoryFactory {

    public MatchHistory createMatchHistory(List<Match> matchList) {
        return new MatchHistory(matchList);
    }

    public MatchHistory createMatchHistory(Match match) {
        return new MatchHistory(match);
    }
}
