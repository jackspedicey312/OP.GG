package entity.MatchList;

import entity.match.Match;

import java.util.List;

public class MatchListFactory {

    public static MatchList createMatchList(List<Match> matchList) {
        return new MatchList(matchList);
    }

    public static MatchList createMatchList(Match match) {
        return new MatchList(match);
    }
}
