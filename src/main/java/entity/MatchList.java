package entity;

import java.util.List;

public class MatchList {

    private final List<Match> matches;

    public MatchList(List<Match> matchList) {
        this.matches = matchList;
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
