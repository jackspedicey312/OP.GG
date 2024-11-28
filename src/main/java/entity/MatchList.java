package entity;

import java.util.ArrayList;
import java.util.List;

public class MatchList {

    private List<Match> matches = new ArrayList<>();

    public MatchList(List<Match> matchList) {
        matches.addAll(matchList);
    }

    public MatchList(Match match) {
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
