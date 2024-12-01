package entity.matchHistory;

import entity.match.Match;

import java.util.List;

public class MatchHistoryFactory {

    public static MatchHistory createMatchHistory(List<Match> matchList) {
        return new MatchHistory(matchList);
    }

    public static MatchHistory createMatchHistory(Match match) {
        return new MatchHistory(match);
    }
}
