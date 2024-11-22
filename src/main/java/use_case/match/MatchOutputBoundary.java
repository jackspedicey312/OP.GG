package use_case.match;

import entity.Match;

import java.util.List;

public interface MatchOutputBoundary {
    /**
     * Presents a list of matches to the user.
     *
     * @param matches The list of matches to present.
     */
    void presentMatches(List<Match> matches);
}



