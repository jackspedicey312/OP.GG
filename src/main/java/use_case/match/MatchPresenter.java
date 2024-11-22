package app;

import entity.Match;
import use_case.match.MatchOutputBoundary;

import java.util.List;

public class MatchPresenter implements MatchOutputBoundary {
    @Override
    public void presentMatches(List<Match> matches) {
        for (Match match : matches) {
            System.out.println("Match ID: " + match.getMatchId());
            System.out.println("Timestamp: " + match.getTimestamp());
            System.out.println("Result: " + match.getResult());
            System.out.println("Participants: " + match.getParticipants());
            System.out.println();
        }
    }
}

