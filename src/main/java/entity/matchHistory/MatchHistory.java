package entity.matchHistory;

import entity.match.Match;

import java.util.ArrayList;
import java.util.List;

public class MatchHistory {

    private List<Match> matches = new ArrayList<>();

    public MatchHistory(List<Match> matchList) {
        matches.addAll(matchList);
    }

    public MatchHistory(Match match) {
        matches.add(match);
    }

    public List<Match> getMatches() {
        return matches;
    }

    public Match getMatch(int index) {
        return matches.get(index);
    }

    public int getLength() {
        return matches.size();
    }
}
